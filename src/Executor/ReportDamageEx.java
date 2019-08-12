package Executor;

import Databse.DamageDB;
import Object.DamageObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for damage report class
 */
public class ReportDamageEx {
    
    private DamageDB DamageDl;
  private DamageObj damage;
  
  public ReportDamageEx() {
    damage = new DamageObj();
    DamageDl = new DamageDB();
  }

  public ReportDamageEx(DamageObj damage) {
    this.damage = damage;
    this.DamageDl = new DamageDB();
  }

  public DamageObj getdamage() {
    return damage;
  }

  public void setdamage(DamageObj damage) {
    this.damage = damage;
  }
  
  public ArrayList<DamageObj> getdamageList() throws Exception{
    try{
      return DamageDl.getdamageList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
