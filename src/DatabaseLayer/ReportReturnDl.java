/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.ReturnOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportReturnDl extends GlobalConnection{
    
    private ReturnOF rturn;
    private ArrayList<ReturnOF> rturns;
    
    public ReportReturnDl() {
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
    
}
