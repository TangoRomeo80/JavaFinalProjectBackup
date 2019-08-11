/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.UserDl;
import ObjectFactory.UserOF;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class UserBl {
  private UserDl UserDl;
  private UserOF user;
  
  public UserBl() {
    user = new UserOF();
    UserDl = new UserDl();
  }

  public UserBl(UserOF user) {
    this.user = user;
    this.UserDl = new UserDl();
  }

  public UserOF getUser() {
    return user;
  }

  public void setUser(UserOF user) {
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
  
  public ArrayList<UserOF> getUserList() throws Exception{
    try{
      return UserDl.getUserList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<UserOF> searchUser() throws Exception{
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
