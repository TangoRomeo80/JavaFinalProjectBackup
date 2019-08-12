package Databse;

import Object.DamageObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to handle damage based interaction with db
 */
public class DamageDB extends GlobalConnection{
    
    private DamageObj damage;
    private ArrayList<DamageObj> damages;
    
    public DamageDB() {
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
    
    // Function to insert the damage in damage table 
    public boolean insertdamage() throws Exception{
      try{
          this.connect();
          // Convert item name to itemId
          String iqry1  = ("SELECT itemId FROM tbl_item where itemName = '"+damage.getitemName()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int itm_id = 0;
          while(rs1.next()){
              itm_id = rs1.getInt("itemId");
          }
          if(itm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.insert("INSERT INTO tbl_damage ( damageName, damageQuantity, damageDate, damageDetail, itemId ) VALUES ('"+damage.getDamageName()+"','"+damage.getDamageQuantity()+"','"+damage.getDamageDate()+"','"+damage.getDamageId()+"','"+itm_id+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the damage in damage table
    public boolean updatedamage() throws Exception{
      try{
          this.connect();
          // Convert item name to itemId
          String iqry1  = ("SELECT itemId FROM tbl_item where itemName = '"+damage.getitemName()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int itm_id = 0;
          while(rs1.next()){
              itm_id = rs1.getInt("itemId");
          }
          if(itm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.update("UPDATE tbl_damage SET damageName='"+damage.getDamageName()+"', damageQuantity='"+damage.getDamageQuantity()+"', damageDate='"+damage.getDamageDate()+"',damageDetail='"+damage.getDamageId()+"', itemId='"+itm_id+"'  WHERE damageId = " + damage.getDamageId());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the damage in damage table
    public boolean deletedamage() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_damage WHERE damageId = " + damage.getDamageId()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the damage detail
    public void loaddamage() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();          
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_damage WHERE damageId = "+damage.getDamageId());
          while(rs.next()){
            damage = new DamageObj(rs.getInt("damageId"), rs.getString("damageName"), rs.getInt("damageQuantity"), rs.getString("damageDate"), rs.getString("damageDetail"), rs.getInt("itemId"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
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
    
    // Function to search the damages
   public ArrayList<DamageObj> searchdamage() throws Exception{
       
    String filterDamageName = damage.getDamageName();  
    int filterDamageId =damage.getDamageId();
    String sqry = "";
    damages = new ArrayList<DamageObj>();
    try{
      this.connect();
      Statement s = this.conn.createStatement();
      String sql1 ="SELECT c.damageId,c.damageName,c.damageQuantity,c.damageDate,c.damageDetail,d.itemName FROM tbl_damage c LEFT JOIN tbl_item d ON c.itemId=d.itemId";

    if (filterDamageName.equals("")) {
      sql1=sql1;               
    } else {
            sql1 += " where c.damageName LIKE '%" + filterDamageName + "%'";
                }      

//ResultSet rs = s.executeQuery("SELECT c.customer_Id,c.customer_Name,c.sur_Name,c.designation_Title,c.address,c.mobile,c.register_Date, d.court_Name FROM customer c LEFT JOIN court d ON c.court_id=d.court_Id"+sqry+" ORDER BY c.customer_Name ");
    ResultSet rs = s.executeQuery(sql1);
    while(rs.next()){
            damage=new DamageObj();      
            damage.setDamageId(rs.getInt("c.damageId"));
            damage.setDamageName(rs.getString("c.damageName"));
            damage.setDamageQuantity(rs.getInt("c.damageQuantity"));
            damage.setDamageDate(rs.getString("c.damageDate"));  
            damage.setDamageDetail(rs.getString("c.damageDetail"));                    
            damage.setitemName(rs.getString("d.itemName"));
        damages.add(damage);
        }
            this.disconnect();
        }catch(Exception ex){
            throw ex;
        }
    return damages;
  }
       
//    String filterdamageName = damage.getDamageName();
//    String filterdamageDate = damage.getDamageDate();
//    String sqry = "";
//    damages = new ArrayList<DamageOF>();
//        try{
//          this.connect();
//          Statement s = this.conn.createStatement();
//          if(!"".equals(filterdamageName)){
//            sqry = "damageName LIKE '%" + filterdamageName +"%' ";
//          }
//          if(!"".equals(filterdamageDate)){
//            if("".equals(sqry))
//              sqry = "damageDate = '"+ filterdamageDate+"' ";
//            else
//              sqry = sqry + " AND damageDate = '"+ filterdamageDate+"' ";
//          }
//          if(!"".equals(sqry)) sqry = "WHERE "+sqry;
//          ResultSet rs = s.executeQuery("SELECT * FROM tbl_damage "+sqry+" ORDER BY damageName, damageDate ");
//          while(rs.next()){            
//            damage = new DamageObj(rs.getInt("damageId"), rs.getString("damageName"), rs.getInt("damageQuantity"), rs.getString("damageDate"), rs.getString("damageDetail"), rs.getInt("itemId"));
//            damages.add(damage);
//          }
//          this.disconnect();
//        }catch(Exception ex){
//          throw ex;
//        }
//        return damages;
//     }
    
}
