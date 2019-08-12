package Databse;

import Object.DamageObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to define damage report based interactions with db 
 */
public class ReportDamageDB extends GlobalConnection{
    
    private DamageObj damage;
    private ArrayList<DamageObj> damages;
    
    public ReportDamageDB() {
        super();
        damage  = new DamageObj();
        damages = new ArrayList<DamageObj>();
    }
    
    public DamageObj getdamage() {
        return damage;
    }

    public void setdamage(DamageObj damage) {
        this.damage = damage;
    }
    
    // Function to list the damages
    public ArrayList<DamageObj> getdamageList() throws Exception{
    damages = new ArrayList<DamageObj>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          // Join query to compare item name 
          ResultSet rs = s.executeQuery("SELECT d.*, i.itemName FROM tbl_item i INNER JOIN tbl_damage d ON i.itemId = d.itemId ORDER BY d.damageId");
          
          while(rs.next()){        
            damage = new DamageObj(rs.getInt("damageId"), rs.getString("damageName"), rs.getInt("damageQuantity"), rs.getString("damageDate"), rs.getString("damageDetail"), rs.getInt("itemId"));
            damage.setitemName(rs.getString("itemName"));
            damages.add(damage);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return damages;
    }
    
}
