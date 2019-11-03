import tornado.ioloop
import tornado.web
import json
import sqlite3

conn = sqlite3.connect('test.db')

class MainHandler(tornado.web.RequestHandler):
    def get(self):
        conn.execute("CREATE TABLE IF NOT EXIST characters (CHAR_NAME TEXT, points TEXT")

class NewCharHandler(tornado.web.RequestHandler):
    def post(self, jsonString):
        parse = json.loads(jsonString)
        name = parse("name")
        arrayPoints = json.dumps(parse("points"))
        conn.execute("INSERT INTO characters VALUES (?,?)", (name, arrayPoints))

class sendInputResponse(tornado.web.RequestHandler):
    def get(self, jsonString):
        ...

    def post(self, jsonString):
        self.write(jsonString)

def make_app():
    return tornado.web.Application({
        (r"/", MainHandler),
        (r"/saveChar", NewCharHandler),
        (r"/help", sendInputResponse)
    })

if __name__ == "__main__":
    app = make_app()
    app.listen(8080)
    tornado.ioloop.IOLoop.current().start()

conn.commit()
conn.close()