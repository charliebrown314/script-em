from flask import Flask
import json
import sqlite3

app = Flask(__name__)
conn = sqlite3.connect('test.db')

@app.route('/')
def createTable():
    conn.execute("CREATE TABLE IF NOT EXIST characters (CHAR_NAME TEXT, points TEXT")

@app.route('/saveChar', methods = ['GET'])
def saveChar(jsonString):
    parse = json.loads(jsonString)
    name = parse("name")
    arrayPoints = json.dumps(parse("points"))
    conn.execute("INSERT INTO characters VALUES (?,?)", (name, arrayPoints))

conn.commit()
conn.close()

@app.route('/sendInput', methods = ['GET', 'POST'])
def sendInputResponse(jsonString):
    if request.method == 'GET':
        return jsonString

if __name__ == "__main__":
    app.run(port=8080,debug=True)

