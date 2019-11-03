from flask import Flask
import json
import mysql.connector

app = Flask(__name__)
db = mysql.connector.connect(host="localhost",user="root",password="password")

cursor = db.cursor()

@app.route('/')
def createTable():
    cursor.execute("CREATE TABLE IF NOT EXIST characters (CHAR_NAME TEXT, points TEXT)")

@app.route('/saveChar', methods = ['GET'])
def saveChar(name, jsonString):
    cursor.execute("INSERT INTO characters VALUES (?,?)", (name, jsonString))

db.commit()

@app.route('/sendInput', methods = ['GET', 'POST'])
def sendInputResponse(jsonString):
    if request.method == 'GET':
        return jsonString

if __name__ == "__main__":
    app.run(port=8080, debug=True)

