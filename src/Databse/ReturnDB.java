package Databse;

import Object.ReturnObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to define return based interactions with db
 */
public class ReturnDB extends GlobalConnection {
    
    private ReturnObj rturn;
    private ArrayList<ReturnObj> rturns;
    
    public ReturnDB() {
        super();
        rturn = new ReturnObj();
        rturns = new ArrayList<ReturnObj>();
    }
    
    public ReturnObj getRturn() {
        return rturn;
    }
    
    public void setRturn(ReturnObj rturn) {
        this.rturn = rturn;
    }
    
    // Function to insert the rturn in rturn table 
    public boolean insertRturn() throws Exception{
      try{
          this.connect();
          // Convert item name to itemId
          String iqry1  = ("SELECT itemId FROM tbl_item where itemName = '"+rturn.getitemName()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int itm_id = 0;
          while(rs1.next()){
              itm_id = rs1.getInt("itemId");
          }
          if(itm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.insert("INSERT INTO tbl_return ( returnName, returnQuantity, returnDate, itemId ) VALUES ('"+rturn.getreturnName()+"' ,'"+rturn.getreturnQuantity()+"','"+rturn.getreturnDate()+"','"+itm_id+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to update the rturn in rturn table
    public boolean updateRturn() throws Exception{
      try{
          this.connect();
          // Convert item name to itemId
          String iqry1  = ("SELECT itemId FROM tbl_item where itemName = '"+rturn.getitemName()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int itm_id = 0;
          while(rs1.next()){
              itm_id = rs1.getInt("itemId");
          }
          if(itm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.update("UPDATE tbl_return SET returnName='"+rturn.getreturnName()+"' ,returnQuantity='"+rturn.getreturnQuantity()+"', returnDate='"+rturn.getreturnDate()+"', itemId='"+rturn.getItemId()+"'  WHERE returnId = " + rturn.getreturnId());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the rturn in rturn table
    public boolean deleteRturn() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_return WHERE returnId = " + rturn.getreturnId()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the rturn detail
    public void loadrturn() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_return WHERE returnId = "+rturn.getreturnId());
          while(rs.next()){
            rturn = new ReturnObj(rs.getInt("returnId"),rs.getString("returnName"), rs.getInt("returnQuantity"), rs.getString("returnDate"), rs.getInt("itemId"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to list the rturns
    public ArrayList<ReturnObj> getRturnList() throws Exception{
    rturns = new ArrayList<ReturnObj>(); 
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          // Join query to compare item name 
          ResultSet rs = s.executeQuery("SELECT r.*, i.itemName FROM tbl_item i INNER JOIN tbl_return r ON i.itemId = r.itemId ORDER BY r.returnId");
          while(rs.next()){        
            rturn = new ReturnObj(rs.getInt("returnId"), rs.getString("returnName") ,rs.getInt("returnQuantity"), rs.getString("returnDate"), rs.getInt("itemId"));
            rturn.setitemName(rs.getString("itemName"));
            rturns.add(rturn);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return rturns;
    }
    
    // Function to search the rturns
    public ArrayList<ReturnObj> searchRturn() throws Exception{
                
        String filterReturnName = rturn.getreturnName();  
            int filterReturnId =rturn.getreturnId();
            String sqry = "";
            rturns = new ArrayList<ReturnObj>();
            try{
              this.connect();
              Statement s = this.conn.createStatement();
              String sql1 ="SELECT c.returnId,c.returnName,c.returnQuantity,c.returnDate,d.itemName FROM tbl_return c LEFT JOIN tbl_item d ON c.itemId=d.itemId";

            if (filterReturnName.equals("")) {
              sql1=sql1;               
            } else {
                    sql1 += " where c.returnName LIKE '%" + filterReturnName + "%'";
                        }      

        //ResultSet rs = s.executeQuery("SELECT c.customer_Id,c.customer_Name,c.sur_Name,c.designation_Title,c.address,c.mobile,c.register_Date, d.court_Name FROM customer c LEFT JOIN court d ON c.court_id=d.court_Id"+sqry+" ORDER BY c.customer_Name ");
            ResultSet rs = s.executeQuery(sql1);
            while(rs.next()){
                    rturn=new ReturnObj();      
                    rturn.setreturnId(rs.getInt("c.returnId"));
                    rturn.setreturnName(rs.getString("c.returnName"));
                    rturn.setreturnQuantity(rs.getInt("c.returnQuantity"));
                    rturn.setreturnDate(rs.getString("c.returnDate"));                      
                    rturn.setitemName(rs.getString("d.itemName"));
                rturns.add(rturn);
                }
                    this.disconnect();
                }catch(Exception ex){
                    throw ex;
                }
            return rturns;
//        String filterReturnName = rturn.getitemName();
//        rturns = new ArrayList<ReturnOF>();
//            try{
//              this.connect();
//              Statement s = this.conn.createStatement();
//              
//              String sqry = "SELECT r.returnId, r.returnName, r.returnQuantity, r.returnDate, i.itemName FROM tbl_return r LEFT JOIN tbl_item i ON i.itemId=r.itemId where r.returnName LIKE '%"+ filterReturnName +"%' ";                          
//
//              ResultSet rs = s.executeQuery(sqry);
//              
//              while(rs.next()){            
//                rturn = new ReturnObj();
//                rturn.setreturnId(rs.getInt("r.returnId"));
//                rturn.setreturnName(rs.getString("r.returnName"));
//                rturn.setreturnQuantity(rs.getInt("r.returnQuantity"));
//                rturn.setreturnDate(rs.getString("r.returnDate"));
//                rturn.setitemName(rs.getString("i.itemName"));                
//                rturns.add(rturn);
//              }
//              this.disconnect();
//            }catch(Exception ex){
//              throw ex;
//            }
//            return rturns;
     }
    
}