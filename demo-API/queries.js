const Pool = require('pg').Pool
const pool = new Pool({
  user: 'roudqjprncsaet',
  host: 'ec2-3-211-221-185.compute-1.amazonaws.com',
  database: 'dd283fabsjbk3c',
  password: 'f77b9dae0ee6b371ee0855996a822412bd842ed5fa9e492df8795c2c9632a1d6',
  port: 5432,
})
const getUsers = (request, response) => {
  pool.query('SELECT * FROM users', (error, results) => {
    if (error) {
      throw error
    }
    response.status(200).json(results.rows)
  })
}

module.exports = {
  getUsers,
}