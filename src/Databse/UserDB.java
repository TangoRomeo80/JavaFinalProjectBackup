package Databse;

import Object.UserObj;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to define user related interactions with db
 */
public class UserDB extends GlobalConnection {
    private UserObj user;
    private ArrayList<UserObj> users;
    
    public UserDB() {
        super();
        user = new UserObj();
        users = new ArrayList<UserObj>();
    }
    
    public UserObj getUser() {
        return user;
    }

    public void setUser(UserObj user) {
        this.user = user;
    }
    
    // Function to insert the user in user table 
    public boolean insertUser() throws Exception{
      try{
          return this.insert("INSERT INTO tbl_user ( userName,userPassword,userEmail,userType ) VALUES ('"+user.getuserName()+"','"+user.getuserPassword()+"','"+user.getuserEmail()+"','"+user.getuserType()+"' )");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the user in user table
    public boolean updateUser() throws Exception{
      try{
          return this.update("UPDATE tbl_user SET userName='"+user.getuserName()+"', userPassword='"+user.getuserPassword()+"', userEmail='"+user.getuserEmail()+"', userType='"+user.getuserType()+"'  WHERE userId = " + user.getuserId());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the user in user table
    public boolean deleteUser() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_user WHERE userId = " + user.getuserId()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the user detail
    public void loadUser() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_user WHERE userId = "+user.getuserId());
          while(rs.next()){
            user = new UserObj(rs.getInt("userId"), rs.getString("userName"), rs.getString("userPassword"), rs.getString("userEmail"), rs.getString("userType"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to list the users
    public ArrayList<UserObj> getUserList() throws Exception{
    users = new ArrayList<UserObj>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_user ORDER BY userId, userType ");
          while(rs.next()){        
            user = new UserObj(rs.getInt("userId"), rs.getString("userName"), rs.getString("userPassword"), rs.getString("userEmail"), rs.getString("userType"));
            users.add(user);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return users;
    }
    
    // Function to search the users
    public ArrayList<UserObj> searchUser() throws Exception{
    String filterUserName = user.getuserName();
    int filterUserId = user.getuserId();
    String sqry = "";
    users = new ArrayList<UserObj>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          if(!"".equals(filterUserName)){
            sqry = "userName LIKE '%" + filterUserName +"%' ";
          }
          if(filterUserId > 0){
            if("".equals(sqry))
              sqry = "userId = '"+ filterUserId+"' ";
            else
              sqry = sqry + " AND userId = '"+ filterUserId+"' ";
          }
          if(!"".equals(sqry)) sqry = "WHERE "+sqry;
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_user "+sqry+" ORDER BY userName ");
          while(rs.next()){            
            user = new UserObj(rs.getInt("userId"), rs.getString("userName"), rs.getString("userPassword"), rs.getString("userEmail"), rs.getString("userType"));
            users.add(user);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return users;
     }
    
    // Function to authenticate the users
    public boolean authenticateUser() throws Exception{
     try{
      this.connect();
      Statement s = this.conn.createStatement();
      ResultSet rs;
      rs = s.executeQuery("SELECT userPassword FROM tbl_user WHERE userName = '"+ user.getuserName()+"' and userType= '"+user.getuserType()+"' ");
      while(rs.next()){
        if(rs.getString("userPassword").equals(user.getuserPassword()))
          return true;
      }
      this.disconnect();
     }catch(Exception ex){
          throw ex;
        }
        return false;
     }
    
    // Functions to change password
    public boolean ChangePassword() throws Exception{
        int result;
        try{
          this.connect();         
          CallableStatement s = this.conn.prepareCall("update tbl_user set userName=?, userPassword=?  where userId=" + user.getuserId()+ " ");        

          s.setString(1, user.getuserName());
          s.setString(2, user.getuserPassword());

          result = s.executeUpdate();
          s.close();
          this.disconnect();
          if(result>0)
            return true;
        }
        catch(Exception ex){
          throw ex;
        }
        return false;
    }
    
}
