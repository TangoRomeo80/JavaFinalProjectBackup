/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.ReturnOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class ReturnDl extends GlobalConnection {
    
    private ReturnOF rturn;
    private ArrayList<ReturnOF> rturns;
    
    public ReturnDl() {
        super();
        rturn = new ReturnOF();
        rturns = new ArrayList<ReturnOF>();
    }
    
    public ReturnOF getRturn() {
        return rturn;
    }
    
    public void setRturn(ReturnOF rturn) {
        this.rturn = rturn;
    }
    
    // Function to insert the rturn in rturn table 
    public boolean insertRturn() throws Exception{
      try{
          this.connect();
          // Convert item name to item_id
          String iqry1  = ("SELECT item_id FROM tbl_item where item_name = '"+rturn.getItem_name()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int itm_id = 0;
          while(rs1.next()){
              itm_id = rs1.getInt("item_id");
          }
          if(itm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.insert("INSERT INTO tbl_return ( return_name, return_quantity, return_date, item_id ) VALUES ('"+rturn.getReturn_name()+"' ,'"+rturn.getReturn_quantity()+"','"+rturn.getReturn_date()+"','"+itm_id+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to update the rturn in rturn table
    public boolean updateRturn() throws Exception{
      try{
          this.connect();
          // Convert item name to item_id
          String iqry1  = ("SELECT item_id FROM tbl_item where item_name = '"+rturn.getItem_name()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int itm_id = 0;
          while(rs1.next()){
              itm_id = rs1.getInt("item_id");
          }
          if(itm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.update("UPDATE tbl_return SET return_name='"+rturn.getReturn_name()+"' ,return_quantity='"+rturn.getReturn_quantity()+"', return_date='"+rturn.getReturn_date()+"', item_id='"+rturn.getItem_id()+"'  WHERE return_id = " + rturn.getReturn_id());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the rturn in rturn table
    public boolean deleteRturn() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_return WHERE return_id = " + rturn.getReturn_id()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the rturn detail
    public void loadrturn() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_return WHERE return_id = "+rturn.getReturn_id());
          while(rs.next()){
            rturn = new ReturnOF(rs.getInt("return_id"),rs.getString("return_name"), rs.getInt("return_quantity"), rs.getString("return_date"), rs.getInt("item_id"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to list the rturns
    public ArrayList<ReturnOF> getRturnList() throws Exception{
    rturns = new ArrayList<ReturnOF>(); 
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          // Join query to compare item name 
          ResultSet rs = s.executeQuery("SELECT r.*, i.item_name FROM tbl_item i INNER JOIN tbl_return r ON i.item_id = r.item_id ORDER BY r.return_id");
          while(rs.next()){        
            rturn = new ReturnOF(rs.getInt("return_id"), rs.getString("return_name") ,rs.getInt("return_quantity"), rs.getString("return_date"), rs.getInt("item_id"));
            rturn.setItem_name(rs.getString("item_name"));
            rturns.add(rturn);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return rturns;
    }
    
    // Function to search the rturns
    public ArrayList<ReturnOF> searchRturn() throws Exception{
                
        String filterReturnName = rturn.getReturn_name();  
            int filterReturnId =rturn.getReturn_id();
            String sqry = "";
            rturns = new ArrayList<ReturnOF>();
            try{
              this.connect();
              Statement s = this.conn.createStatement();
              String sql1 ="SELECT c.return_id,c.return_name,c.return_quantity,c.return_date,d.item_name FROM tbl_return c LEFT JOIN tbl_item d ON c.item_id=d.item_id";

            if (filterReturnName.equals("")) {
              sql1=sql1;               
            } else {
                    sql1 += " where c.return_name LIKE '%" + filterReturnName + "%'";
                        }      

        //ResultSet rs = s.executeQuery("SELECT c.customer_Id,c.customer_Name,c.sur_Name,c.designation_Title,c.address,c.mobile,c.register_Date, d.court_Name FROM customer c LEFT JOIN court d ON c.court_id=d.court_Id"+sqry+" ORDER BY c.customer_Name ");
            ResultSet rs = s.executeQuery(sql1);
            while(rs.next()){
                    rturn=new ReturnOF();      
                    rturn.setReturn_id(rs.getInt("c.return_id"));
                    rturn.setReturn_name(rs.getString("c.return_name"));
                    rturn.setReturn_quantity(rs.getInt("c.return_quantity"));
                    rturn.setReturn_date(rs.getString("c.return_date"));                      
                    rturn.setItem_name(rs.getString("d.item_name"));
                rturns.add(rturn);
                }
                    this.disconnect();
                }catch(Exception ex){
                    throw ex;
                }
            return rturns;
//        String filterReturnName = rturn.getItem_name();
//        rturns = new ArrayList<ReturnOF>();
//            try{
//              this.connect();
//              Statement s = this.conn.createStatement();
//              
//              String sqry = "SELECT r.return_id, r.return_name, r.return_quantity, r.return_date, i.item_name FROM tbl_return r LEFT JOIN tbl_item i ON i.item_id=r.item_id where r.return_name LIKE '%"+ filterReturnName +"%' ";                          
//
//              ResultSet rs = s.executeQuery(sqry);
//              
//              while(rs.next()){            
//                rturn = new ReturnOF();
//                rturn.setReturn_id(rs.getInt("r.return_id"));
//                rturn.setReturn_name(rs.getString("r.return_name"));
//                rturn.setReturn_quantity(rs.getInt("r.return_quantity"));
//                rturn.setReturn_date(rs.getString("r.return_date"));
//                rturn.setItem_name(rs.getString("i.item_name"));                
//                rturns.add(rturn);
//              }
//              this.disconnect();
//            }catch(Exception ex){
//              throw ex;
//            }
//            return rturns;
     }
    
}