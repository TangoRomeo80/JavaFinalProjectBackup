package Databse;

import Object.ReturnObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to define return report interactions with db
 */
public class ReportReturnDB extends GlobalConnection{
    
    private ReturnObj rturn;
    private ArrayList<ReturnObj> rturns;
    
    public ReportReturnDB() {
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
    
}
