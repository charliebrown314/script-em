from flask import Flask
import json
import sqlite3

app = Flask(__name__)

@app.route('/')
def table():
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    cursor.execute("CREATE TABLE IF NOT EXISTS characters (CHAR_NAME TEXT, points TEXT)")
    conn.commit()
    return 0

@app.route('/saveChar', methods = ['GET'])
def saveChar(name, jsonString):
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()
    cursor.execute("INSERT INTO characters VALUES (?,?)", (name, jsonString))
    conn.commit()
    return 0

@app.route('/sendInput', methods = ['GET', 'POST'])
def sendInputResponse(jsonString):
    if request.method == 'GET':
        return jsonString

if __name__ == "__main__":
    app.run(port=8080, debug=True)

