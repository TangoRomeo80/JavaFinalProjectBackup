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
          
          return this.insert("INSERT INTO tbl_sales ( sale_customer_name, sale_customer_address, sale_date, sale_bill_no, sale_rate, sale_quantity, itemId ) VALUES ('"+sales.getsalesCustomerName()+"','"+sales.getsalesCustomerAddress()+"','"+sales.getsalesDate()+"','"+sales.getsalesBillNo()+"','"+sales.getsalesRate()+"','"+sales.getsalesQuantity()+"','"+itm_id+"')");
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
          
          return this.update("UPDATE tbl_sales SET sale_customer_name='"+sales.getsalesCustomerName()+"', sale_customer_address='"+sales.getsalesCustomerAddress()+"', sale_date='"+sales.getsalesDate()+"', sale_bill_no='"+sales.getsalesBillNo()+"', sale_rate='"+sales.getsalesRate()+"', sale_quantity='"+sales.getsalesQuantity()+"', itemId='"+uitm_id+"'   WHERE sale_id = " + sales.getsalesId());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the sales in sales table
    public boolean deleteSales() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_sales WHERE sale_id = " + sales.getsalesId()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the sales detail
    public void loadSales() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_sales WHERE sale_id = "+sales.getsalesId());
          while(rs.next()){
            sales = new SalesObj(rs.getInt("sale_id"), rs.getString("sale_customer_name"), rs.getString("sale_customer_address"), rs.getString("sale_date"), rs.getInt("sale_bill_no"), rs.getInt("sale_rate"), rs.getInt("sale_quantity"), rs.getInt("itemId"));
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
          ResultSet rs = s.executeQuery("SELECT s.*, i.itemName FROM tbl_item i INNER JOIN tbl_sales s ON i.itemId = s.itemId ORDER BY s.sale_id");
          while(rs.next()){        
            sales = new SalesObj(rs.getInt("sale_id"), rs.getString("sale_customer_name"), rs.getString("sale_customer_address"), rs.getString("sale_date"), rs.getInt("sale_bill_no"), rs.getInt("sale_rate"), rs.getInt("sale_quantity"), rs.getInt("itemId"));
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
              String sql1 ="SELECT s.sale_id,s.sale_customer_name,s.sale_customer_address,s.sale_date,s.sale_bill_no,s.sale_rate,s.sale_quantity,i.itemName FROM tbl_sales s LEFT JOIN tbl_item i ON s.itemId=i.itemId";

            if (filterCustoName.equals("")) {
              sql1=sql1;               
            } else {
                sql1 += " where s.sale_customer_name LIKE '%" + filterCustoName + "%'";
            }      
        //ResultSet rs = s.executeQuery("SELECT c.customer_Id,c.customer_Name,c.sur_Name,c.designation_Title,c.address,c.mobile,c.register_Date, d.court_Name FROM customer c LEFT JOIN court d ON c.court_id=d.court_Id"+sqry+" ORDER BY c.customer_Name ");
            ResultSet rs = s.executeQuery(sql1);
            while(rs.next()){
                    sales=new SalesObj();      
                    sales.setsalesId(rs.getInt("s.sale_id"));
                    sales.setsalesCustomerName(rs.getString("s.sale_customer_name"));
                    sales.setsalesCustomerAddress(rs.getString("s.sale_customer_address"));                    
                    sales.setsalesDate(rs.getString("s.sale_date"));  
                    sales.setsalesBillNo(rs.getInt("s.sale_bill_no")); 
                    sales.setsalesRate(rs.getInt("s.sale_rate")); 
                    sales.setsalesQuantity(rs.getInt("s.sale_quantity"));
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
