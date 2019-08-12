package Executor;

import Databse.DamageDB;
import Object.DamageObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * Executor class for damage class
 */
public class DamageEx {
      
  private DamageDB DamageDl;
  private DamageObj damage;
  
  public DamageEx() {
    damage = new DamageObj();
    DamageDl = new DamageDB();
  }

  public DamageEx(DamageObj damage) {
    this.damage = damage;
    this.DamageDl = new DamageDB();
  }

  public DamageObj getdamage() {
    return damage;
  }

  public void setdamage(DamageObj damage) {
    this.damage = damage;
  }
  
//  public boolean authenticatedamage() throws Exception{
//    try{
//      DamageDB.setdamage(damage);
//      if(DamageDB.authenticatedamage()){
//        DamageDB.loaddamage();
//        damage = DamageDB.getdamage();
//        return true;
//      }
//    }catch( Exception ex){
//      throw ex;
//    }
//    return false;
//  }
//  
  public boolean insertdamage() throws Exception{
    try{
      DamageDl.setdamage(damage);
      return DamageDl.insertdamage();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean updatedamage() throws Exception{
    try{
      DamageDl.setdamage(damage);
      return DamageDl.updatedamage();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean deletedamage() throws Exception{
    try{
      DamageDl.setdamage(damage);
      return DamageDl.deletedamage();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<DamageObj> getdamageList() throws Exception{
    try{
      return DamageDl.getdamageList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<DamageObj> searchdamage() throws Exception{
    try{
      DamageDl.setdamage(damage);
      return DamageDl.searchdamage();
    }catch(Exception ex){
      throw ex;
    }
  }
}
