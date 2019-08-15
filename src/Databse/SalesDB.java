package Databse;

import Object.SalesObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to handle sales related interactions with db
 */
public class SalesDB extends GlobalConnection {
    
    private SalesObj sales;
    private ArrayList<SalesObj> saless;
    
    public SalesDB() {
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
    
    // Function to insert the sales in sales table 
    public boolean insertSales() throws Exception{
      try{
          this.connect();
          
          // Convert item name to itemId
          String iqry1  = ("SELECT itemId FROM tbl_item where itemName = '"+sales.getitemName()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int itm_id = 0;
          while(rs1.next()){
              itm_id = rs1.getInt("itemId");
          }
          if(itm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.insert("INSERT INTO tbl_sales ( saleCustomerName, saleCustomerAddress, saleDate, saleBillNo, saleRate, saleQuantity, itemId ) VALUES ('"+sales.getsalesCustomerName()+"','"+sales.getsalesCustomerAddress()+"','"+sales.getsalesDate()+"','"+sales.getsalesBillNo()+"','"+sales.getsalesRate()+"','"+sales.getsalesQuantity()+"','"+itm_id+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the sales in sales table
    public boolean updateSales() throws Exception{
      try{
          this.connect();
          // Convert item name to itemId
          String uqry1  = ("SELECT itemId FROM tbl_item where itemName = '"+sales.getitemName()+"' ");
          Statement us  = this.conn.createStatement();
          ResultSet rs1 = us.executeQuery(uqry1);
          int uitm_id = 0;
          while(rs1.next()){
              uitm_id = rs1.getInt("itemId");
          }
          if(uitm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.update("UPDATE tbl_sales SET saleCustomerName='"+sales.getsalesCustomerName()+"', saleCustomerAddress='"+sales.getsalesCustomerAddress()+"', saleDate='"+sales.getsalesDate()+"', saleBillNo='"+sales.getsalesBillNo()+"', saleRate='"+sales.getsalesRate()+"', saleQuantity='"+sales.getsalesQuantity()+"', itemId='"+uitm_id+"'   WHERE saleId = " + sales.getsalesId());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the sales in sales table
    public boolean deleteSales() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_sales WHERE saleId = " + sales.getsalesId()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the sales detail
    public void loadSales() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_sales WHERE saleId = "+sales.getsalesId());
          while(rs.next()){
            sales = new SalesObj(rs.getInt("saleId"), rs.getString("saleCustomerName"), rs.getString("saleCustomerAddress"), rs.getString("saleDate"), rs.getInt("saleBillNo"), rs.getInt("saleRate"), rs.getInt("saleQuantity"), rs.getInt("itemId"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
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
    
    // Function to search the saless
   public ArrayList<SalesObj> searchSales() throws Exception{
       
        String filterCustoName = sales.getsalesCustomerName();  
            int filterSalesId =sales.getsalesId();
            String sqry = "";
            saless = new ArrayList<SalesObj>();
            try{
              this.connect();
              Statement s = this.conn.createStatement();
              String sql1 ="SELECT s.saleId,s.saleCustomerName,s.saleCustomerAddress,s.saleDate,s.saleBillNo,s.saleRate,s.saleQuantity,i.itemName FROM tbl_sales s LEFT JOIN tbl_item i ON s.itemId=i.itemId";

            if (filterCustoName.equals("")) {
              sql1=sql1;               
            } else {
                sql1 += " where s.saleCustomerName LIKE '%" + filterCustoName + "%'";
            }      
        //ResultSet rs = s.executeQuery("SELECT c.customer_Id,c.customer_Name,c.sur_Name,c.designation_Title,c.address,c.mobile,c.register_Date, d.court_Name FROM customer c LEFT JOIN court d ON c.court_id=d.court_Id"+sqry+" ORDER BY c.customer_Name ");
            ResultSet rs = s.executeQuery(sql1);
            while(rs.next()){
                    sales=new SalesObj();      
                    sales.setsalesId(rs.getInt("s.saleId"));
                    sales.setsalesCustomerName(rs.getString("s.saleCustomerName"));
                    sales.setsalesCustomerAddress(rs.getString("s.saleCustomerAddress"));                    
                    sales.setsalesDate(rs.getString("s.saleDate"));  
                    sales.setsalesBillNo(rs.getInt("s.saleBillNo")); 
                    sales.setsalesRate(rs.getInt("s.saleRate")); 
                    sales.setsalesQuantity(rs.getInt("s.saleQuantity"));
                    sales.setitemName(rs.getString("i.itemName"));
                saless.add(sales);
                }
                    this.disconnect();
                }catch(Exception ex){
                    throw ex;
                }
            return saless;
   
    }
}
