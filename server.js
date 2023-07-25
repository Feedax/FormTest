const express = require('express');
const mysql = require('mysql2');

const app = express();
const port = 3000;

const dbConnection = mysql.createConnection({
  host: 'localhost',
  port: 3306,
  user: 'root',
  password: '1234',
  database: 'sys',
});

app.use(express.urlencoded({ extended: true }));

app.get('/', (req, res) => {
  res.send('<h1>Form</h1><form action="/submit" method="post"><label for="name">Name:</label><input type="text" id="name" name="name" required><br><label for="email">Email:</label><input type="email" id="email" name="email" required><br><input type="submit" value="Send"></form>')
});

app.post('/submit', (req, res) => {
  const { name, email } = req.body;
  saveDataToDatabase(name, email);
  res.send('<p>Data successfully sent.</p>');
});

function saveDataToDatabase(name, email) {
  const sql = 'INSERT INTO user (name, email) VALUES (?, ?)';
  dbConnection.query(sql, [name, email], (err, result) => {
    if (err) throw err;
    console.log('Data successfully saved.');
  });
}

app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});