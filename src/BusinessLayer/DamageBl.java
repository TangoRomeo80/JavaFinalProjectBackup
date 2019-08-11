/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.DamageDl;
import ObjectFactory.DamageOF;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class DamageBl {
      
  private DamageDl DamageDl;
  private DamageOF damage;
  
  public DamageBl() {
    damage = new DamageOF();
    DamageDl = new DamageDl();
  }

  public DamageBl(DamageOF damage) {
    this.damage = damage;
    this.DamageDl = new DamageDl();
  }

  public DamageOF getdamage() {
    return damage;
  }

  public void setdamage(DamageOF damage) {
    this.damage = damage;
  }
  
//  public boolean authenticatedamage() throws Exception{
//    try{
//      DamageDl.setdamage(damage);
//      if(DamageDl.authenticatedamage()){
//        DamageDl.loaddamage();
//        damage = DamageDl.getdamage();
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
  
  public ArrayList<DamageOF> getdamageList() throws Exception{
    try{
      return DamageDl.getdamageList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<DamageOF> searchdamage() throws Exception{
    try{
      DamageDl.setdamage(damage);
      return DamageDl.searchdamage();
    }catch(Exception ex){
      throw ex;
    }
  }
}
