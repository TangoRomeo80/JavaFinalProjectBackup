package Executor;

import Databse.UserDB;
import Object.UserObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for user class
 */
public class UserEx {
  private UserDB UserDl;
  private UserObj user;
  
  public UserEx() {
    user = new UserObj();
    UserDl = new UserDB();
  }

  public UserEx(UserObj user) {
    this.user = user;
    this.UserDl = new UserDB();
  }

  public UserObj getUser() {
    return user;
  }

  public void setUser(UserObj user) {
    this.user = user;
  }
  
  public boolean authenticateUser() throws Exception{
    try{
      UserDl.setUser(user);
      if(UserDl.authenticateUser()){
        UserDl.loadUser();
        user = UserDl.getUser();
        return true;
      }
    }catch( Exception ex){
      throw ex;
    }
    return false;
  }
  
  public boolean insertUser() throws Exception{
    try{
      UserDl.setUser(user);
      return UserDl.insertUser();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean updateUser() throws Exception{
    try{
      UserDl.setUser(user);
      return UserDl.updateUser();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean deleteUser() throws Exception{
    try{
      UserDl.setUser(user);
      return UserDl.deleteUser();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<UserObj> getUserList() throws Exception{
    try{
      return UserDl.getUserList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<UserObj> searchUser() throws Exception{
    try{
      UserDl.setUser(user);
      return UserDl.searchUser();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean ChangePassword() throws Exception{
    try{
      UserDl.setUser(user);
      return UserDl.ChangePassword();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
