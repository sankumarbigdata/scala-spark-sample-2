/**
  * (C) Harleen Singh Mann
  * Create connection
  * Crete statement instance
  * Execute statement
  * Print results - using a while loop
  */

import java.sql.Connection
import java.sql.DriverManager

object mysql_try {
  def main(args: Array[String]): Unit = {
    var conn: Connection = null
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","password")
      
    val stmt = conn.createStatement()
    val rs = stmt.executeQuery("SELECT * FROM table1")

    while(rs.next()) {
      val r = rs.getInt("c1") + " " + rs.getString("c2")
      println(r)
    }
  }



}
