/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chhabi
 */
public class GlobalConnection {
    // PARAMETER FOR DATABASE
  private String userName;      //Database Username
  private String password;      //Database Password
  private String host;          //Database Host
  private String port;          //Database port number
  private String dbName;        //Database Name
  private String url;
  
  // PARAMETER FOR QUERING THE DATABASE
  protected Connection conn;
  
    
  public GlobalConnection(){
    this.userName = "root";
    this.password = "password";
    this.host = "localhost";
    this.port = "3306";
    this.dbName = "inventory";
    this.url = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dbName;
    this.conn = null;
  }
  
  /**
   * Function Connection
   * Connects to the SQL Database
   * @throws ClassNotFoundException
   * @throws SQLException
   * @throws InstantiationException
   * @throws IllegalAccessException 
   */
  public void connect() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      this.conn = DriverManager.getConnection(this.url, this.userName, this.password);
      //return this.conn;
    } catch (Exception ex){
            try {
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(GlobalConnection.class.getName()).log(Level.SEVERE, null, ex1);
            }
    }
  }
  
  /**
   * Function disconnect
   * Disconnect the SQL Connection
   * @throws SQLException 
   */
  public void disconnect() throws SQLException{
    if (this.conn != null)
    {
      try
      {
        this.conn.close ();
      }
      catch(SQLException ex){
        throw ex;
      }
    }
  }
  /**
   * Function select
   * Used to run the select query in database
   * @param sql String contains the sql query to be executed
   * @return ResultSet
   * @throws Exception 
   */
  public ResultSet select(String sql) throws Exception{
    try{
      this.connect();
      Statement s = this.conn.createStatement();
      s.executeQuery(sql);
      
      ResultSet rs = s.getResultSet();
      return rs;
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean insert(String sql) throws Exception{
    try{
      this.connect();
      Statement s = this.conn.createStatement();
      int n = s.executeUpdate(sql);
      if (n == 1){
          return true;
      }
      else{
          return false;
      }
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean update(String sql) throws Exception{
    try{
      this.connect();
      Statement s = this.conn.createStatement();
      int n = s.executeUpdate(sql);
      if (n == 1){
          return true;
      }
      else{
          return false;
      }
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean delete(String sql) throws Exception{
    try{
      this.connect();
      Statement s = this.conn.createStatement();
      int n = s.executeUpdate(sql);
      if (n == 1){
          return true;
      }
      else{
          return false;
      }
    }catch(Exception ex){
      throw ex;
    }
  }
}
