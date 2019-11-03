from flask import Flask
import json
import sqlite3

app = Flask(__name__)
conn = sqlite3.connect('database.db')

@app.route('/')
def table():
    cursor = conn.cursor()
    cursor.execute("CREATE TABLE IF NOT EXISTS characters (CHAR_NAME TEXT, points TEXT)")

@app.route('/saveChar', methods = ['GET'])
def saveChar(name, jsonString):
    cursor = conn.cursor()
    cursor.execute("INSERT INTO characters VALUES (?,?)", (name, jsonString))

conn.commit()

@app.route('/sendInput', methods = ['GET', 'POST'])
def sendInputResponse(jsonString):
    if request.method == 'GET':
        return jsonString

if __name__ == "__main__":
    app.run(port=8080, debug=True)

