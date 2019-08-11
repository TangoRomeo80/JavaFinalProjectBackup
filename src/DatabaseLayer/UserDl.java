/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.UserOF;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class UserDl extends GlobalConnection {
    private UserOF user;
    private ArrayList<UserOF> users;
    
    public UserDl() {
        super();
        user = new UserOF();
        users = new ArrayList<UserOF>();
    }
    
    public UserOF getUser() {
        return user;
    }

    public void setUser(UserOF user) {
        this.user = user;
    }
    
    // Function to insert the user in user table 
    public boolean insertUser() throws Exception{
      try{
          return this.insert("INSERT INTO tbl_user ( user_name,user_password,user_email,user_type ) VALUES ('"+user.getUser_name()+"','"+user.getUser_password()+"','"+user.getUser_email()+"','"+user.getUser_type()+"' )");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the user in user table
    public boolean updateUser() throws Exception{
      try{
          return this.update("UPDATE tbl_user SET user_name='"+user.getUser_name()+"', user_password='"+user.getUser_password()+"', user_email='"+user.getUser_email()+"', user_type='"+user.getUser_type()+"'  WHERE user_id = " + user.getUser_id());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the user in user table
    public boolean deleteUser() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_user WHERE user_id = " + user.getUser_id()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the user detail
    public void loadUser() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_user WHERE user_id = "+user.getUser_id());
          while(rs.next()){
            user = new UserOF(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_password"), rs.getString("user_email"), rs.getString("user_type"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to list the users
    public ArrayList<UserOF> getUserList() throws Exception{
    users = new ArrayList<UserOF>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_user ORDER BY user_id, user_type ");
          while(rs.next()){        
            user = new UserOF(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_password"), rs.getString("user_email"), rs.getString("user_type"));
            users.add(user);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return users;
    }
    
    // Function to search the users
    public ArrayList<UserOF> searchUser() throws Exception{
    String filterUserName = user.getUser_name();
    int filterUserId = user.getUser_id();
    String sqry = "";
    users = new ArrayList<UserOF>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          if(!"".equals(filterUserName)){
            sqry = "user_name LIKE '%" + filterUserName +"%' ";
          }
          if(filterUserId > 0){
            if("".equals(sqry))
              sqry = "user_id = '"+ filterUserId+"' ";
            else
              sqry = sqry + " AND user_id = '"+ filterUserId+"' ";
          }
          if(!"".equals(sqry)) sqry = "WHERE "+sqry;
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_user "+sqry+" ORDER BY user_name ");
          while(rs.next()){            
            user = new UserOF(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("userPassword"), rs.getString("user_email"), rs.getString("user_type"));
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
      rs = s.executeQuery("SELECT user_password FROM tbl_user WHERE user_name = '"+ user.getUser_name()+"' and user_type= '"+user.getUser_type()+"' ");
      while(rs.next()){
        if(rs.getString("user_password").equals(user.getUser_password()))
          return true;
        if(rs.getString("user_type").equals(user.getUser_type()))
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
          CallableStatement s = this.conn.prepareCall("update tbl_user set user_name=?, user_password=?  where user_id=" + user.getUser_id()+ " ");        

          s.setString(1, user.getUser_name());
          s.setString(2, user.getUser_password());

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
