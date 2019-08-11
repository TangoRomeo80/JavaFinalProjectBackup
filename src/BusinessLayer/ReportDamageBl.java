/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.DamageDl;
import ObjectFactory.DamageOF;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportDamageBl {
    
    private DamageDl DamageDl;
  private DamageOF damage;
  
  public ReportDamageBl() {
    damage = new DamageOF();
    DamageDl = new DamageDl();
  }

  public ReportDamageBl(DamageOF damage) {
    this.damage = damage;
    this.DamageDl = new DamageDl();
  }

  public DamageOF getdamage() {
    return damage;
  }

  public void setdamage(DamageOF damage) {
    this.damage = damage;
  }
  
  public ArrayList<DamageOF> getdamageList() throws Exception{
    try{
      return DamageDl.getdamageList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
