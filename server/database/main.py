from flask import Flask
import json
import sqlite3

app = Flask(__name__)
conn = sqlite3.connect('test.db')
c = conn.cursor()

@app.route('/')
def createTable():
    c.execute("CREATE TABLE IF NOT EXIST characters (CHAR_NAME TEXT, points TEXT)")

@app.route('/saveChar', methods = ['GET'])
def saveChar(name, jsonString):
    c.execute("INSERT INTO characters VALUES (?,?)", (name, jsonString))

conn.commit()
conn.close()

@app.route('/sendInput', methods = ['GET', 'POST'])
def sendInputResponse(jsonString):
    if request.method == 'GET':
        return jsonString

if __name__ == "__main__":
    app.run(port=8080, debug=True)

