package com.revature.DAO;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory
{
  public ConnectionFactory() {}
  
  public static Connection getConnection()
    throws SQLException
  {
    Connection c = null;
    



    try
    {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      
      String url = System.getenv("DEMO_DB_URL");
      String username = System.getenv("DEMO_DB_USERNAME");
      String password = System.getenv("DEMO_DB_PASSWORD");
      

      c = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException ex) {
      System.out.println("unable to load driver class!");
    }
    






    return c;
  }
}