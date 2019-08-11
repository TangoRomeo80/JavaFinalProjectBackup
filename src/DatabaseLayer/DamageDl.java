/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.DamageOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class DamageDl extends GlobalConnection{
    
    private DamageOF damage;
    private ArrayList<DamageOF> damages;
    
    public DamageDl() {
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
    
    // Function to insert the damage in damage table 
    public boolean insertdamage() throws Exception{
      try{
          this.connect();
          // Convert item name to item_id
          String iqry1  = ("SELECT item_id FROM tbl_item where item_name = '"+damage.getItem_name()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int itm_id = 0;
          while(rs1.next()){
              itm_id = rs1.getInt("item_id");
          }
          if(itm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.insert("INSERT INTO tbl_damage ( damage_name, damage_quantity, damage_date, damage_detail, item_id ) VALUES ('"+damage.getDamage_name()+"','"+damage.getDamage_quantity()+"','"+damage.getDamage_date()+"','"+damage.getDamage_detail()+"','"+itm_id+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the damage in damage table
    public boolean updatedamage() throws Exception{
      try{
          this.connect();
          // Convert item name to item_id
          String iqry1  = ("SELECT item_id FROM tbl_item where item_name = '"+damage.getItem_name()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int itm_id = 0;
          while(rs1.next()){
              itm_id = rs1.getInt("item_id");
          }
          if(itm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.update("UPDATE tbl_damage SET damage_name='"+damage.getDamage_name()+"', damage_quantity='"+damage.getDamage_quantity()+"', damage_date='"+damage.getDamage_date()+"',damage_detail='"+damage.getDamage_detail()+"', item_id='"+itm_id+"'  WHERE damage_id = " + damage.getDamage_id());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the damage in damage table
    public boolean deletedamage() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_damage WHERE damage_id = " + damage.getDamage_id()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the damage detail
    public void loaddamage() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();          
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_damage WHERE damage_id = "+damage.getDamage_id());
          while(rs.next()){
            damage = new DamageOF(rs.getInt("damage_id"), rs.getString("damage_name"), rs.getInt("damage_quantity"), rs.getString("damage_date"), rs.getString("damage_detail"), rs.getInt("item_id"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
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
    
    // Function to search the damages
   public ArrayList<DamageOF> searchdamage() throws Exception{
       
    String filterDamageName = damage.getDamage_name();  
    int filterDamageId =damage.getDamage_id();
    String sqry = "";
    damages = new ArrayList<DamageOF>();
    try{
      this.connect();
      Statement s = this.conn.createStatement();
      String sql1 ="SELECT c.damage_id,c.damage_name,c.damage_quantity,c.damage_date,c.damage_detail,d.item_name FROM tbl_damage c LEFT JOIN tbl_item d ON c.item_id=d.item_id";

    if (filterDamageName.equals("")) {
      sql1=sql1;               
    } else {
            sql1 += " where c.damage_name LIKE '%" + filterDamageName + "%'";
                }      

//ResultSet rs = s.executeQuery("SELECT c.customer_Id,c.customer_Name,c.sur_Name,c.designation_Title,c.address,c.mobile,c.register_Date, d.court_Name FROM customer c LEFT JOIN court d ON c.court_id=d.court_Id"+sqry+" ORDER BY c.customer_Name ");
    ResultSet rs = s.executeQuery(sql1);
    while(rs.next()){
            damage=new DamageOF();      
            damage.setDamage_id(rs.getInt("c.damage_id"));
            damage.setDamage_name(rs.getString("c.damage_name"));
            damage.setDamage_quantity(rs.getInt("c.damage_quantity"));
            damage.setDamage_date(rs.getString("c.damage_date"));  
            damage.setDamage_detail(rs.getString("c.damage_detail"));                    
            damage.setItem_name(rs.getString("d.item_name"));
        damages.add(damage);
        }
            this.disconnect();
        }catch(Exception ex){
            throw ex;
        }
    return damages;
  }
       
//    String filterdamageName = damage.getDamage_name();
//    String filterdamageDate = damage.getDamage_date();
//    String sqry = "";
//    damages = new ArrayList<DamageOF>();
//        try{
//          this.connect();
//          Statement s = this.conn.createStatement();
//          if(!"".equals(filterdamageName)){
//            sqry = "damage_name LIKE '%" + filterdamageName +"%' ";
//          }
//          if(!"".equals(filterdamageDate)){
//            if("".equals(sqry))
//              sqry = "damage_date = '"+ filterdamageDate+"' ";
//            else
//              sqry = sqry + " AND damage_date = '"+ filterdamageDate+"' ";
//          }
//          if(!"".equals(sqry)) sqry = "WHERE "+sqry;
//          ResultSet rs = s.executeQuery("SELECT * FROM tbl_damage "+sqry+" ORDER BY damage_name, damage_date ");
//          while(rs.next()){            
//            damage = new DamageOF(rs.getInt("damage_id"), rs.getString("damage_name"), rs.getInt("damage_quantity"), rs.getString("damage_date"), rs.getString("damage_detail"), rs.getInt("item_id"));
//            damages.add(damage);
//          }
//          this.disconnect();
//        }catch(Exception ex){
//          throw ex;
//        }
//        return damages;
//     }
    
}
