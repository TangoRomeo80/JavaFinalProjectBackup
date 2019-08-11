/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.DamageOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportDamageDl extends GlobalConnection{
    
    private DamageOF damage;
    private ArrayList<DamageOF> damages;
    
    public ReportDamageDl() {
        super();
        damage  = new DamageOF();
        damages = new ArrayList<DamageOF>();
    }
    
    public DamageOF getdamage() {
        return damage;
    }

    public void setdamage(DamageOF damage) {
        this.damage = damage;
    }
    
    // Function to list the damages
    public ArrayList<DamageOF> getdamageList() throws Exception{
    damages = new ArrayList<DamageOF>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          // Join query to compare item name 
          ResultSet rs = s.executeQuery("SELECT d.*, i.item_name FROM tbl_item i INNER JOIN tbl_damage d ON i.item_id = d.item_id ORDER BY d.damage_id");
          
          while(rs.next()){        
            damage = new DamageOF(rs.getInt("damage_id"), rs.getString("damage_name"), rs.getInt("damage_quantity"), rs.getString("damage_date"), rs.getString("damage_detail"), rs.getInt("item_id"));
            damage.setItem_name(rs.getString("item_name"));
            damages.add(damage);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return damages;
    }
    
}
