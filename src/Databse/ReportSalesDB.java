package Databse;

import Object.SalesObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to define sales report interaction with db
 */
public class ReportSalesDB extends GlobalConnection{
    
    private SalesObj sales;
    private ArrayList<SalesObj> saless;
    
    public ReportSalesDB() {
        super();
        sales = new SalesObj();
        saless = new ArrayList<SalesObj>();
    }
    
    public SalesObj getSales() {
        return sales;
    }

    public void setSales(SalesObj sales) {
        this.sales = sales;
    }
    
    // Function to list the saless
    public ArrayList<SalesObj> getSalesList() throws Exception{
    saless = new ArrayList<SalesObj>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT s.*, i.itemName FROM tbl_item i INNER JOIN tbl_sales s ON i.itemId = s.itemId ORDER BY s.saleId");
          while(rs.next()){        
            sales = new SalesObj(rs.getInt("saleId"), rs.getString("saleCustomerName"), rs.getString("saleCustomerAddress"), rs.getString("saleDate"), rs.getInt("saleBillNo"), rs.getInt("saleRate"), rs.getInt("saleQuantity"), rs.getInt("itemId"));
            sales.setitemName(rs.getString("itemName"));
            saless.add(sales);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return saless;
    }
    
}
