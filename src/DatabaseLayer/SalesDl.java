/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.SalesOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class SalesDl extends GlobalConnection {
    
    private SalesOF sales;
    private ArrayList<SalesOF> saless;
    
    public SalesDl() {
        super();
        sales = new SalesOF();
        saless = new ArrayList<SalesOF>();
    }
    
    public SalesOF getSales() {
        return sales;
    }

    public void setSales(SalesOF sales) {
        this.sales = sales;
    }
    
    // Function to insert the sales in sales table 
    public boolean insertSales() throws Exception{
      try{
          this.connect();
          
          // Convert item name to item_id
          String iqry1  = ("SELECT item_id FROM tbl_item where item_name = '"+sales.getItem_name()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int itm_id = 0;
          while(rs1.next()){
              itm_id = rs1.getInt("item_id");
          }
          if(itm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.insert("INSERT INTO tbl_sales ( sale_customer_name, sale_customer_address, sale_date, sale_bill_no, sale_rate, sale_quantity, item_id ) VALUES ('"+sales.getSales_customer_name()+"','"+sales.getSales_customer_address()+"','"+sales.getSales_date()+"','"+sales.getSales_bill_no()+"','"+sales.getSales_rate()+"','"+sales.getSales_quantity()+"','"+itm_id+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the sales in sales table
    public boolean updateSales() throws Exception{
      try{
          this.connect();
          // Convert item name to item_id
          String uqry1  = ("SELECT item_id FROM tbl_item where item_name = '"+sales.getItem_name()+"' ");
          Statement us  = this.conn.createStatement();
          ResultSet rs1 = us.executeQuery(uqry1);
          int uitm_id = 0;
          while(rs1.next()){
              uitm_id = rs1.getInt("item_id");
          }
          if(uitm_id==0){
              throw new Exception("Select a Valid Item Name");
          }
          
          return this.update("UPDATE tbl_sales SET sale_customer_name='"+sales.getSales_customer_name()+"', sale_customer_address='"+sales.getSales_customer_address()+"', sale_date='"+sales.getSales_date()+"', sale_bill_no='"+sales.getSales_bill_no()+"', sale_rate='"+sales.getSales_rate()+"', sale_quantity='"+sales.getSales_quantity()+"', item_id='"+uitm_id+"'   WHERE sale_id = " + sales.getSales_id());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the sales in sales table
    public boolean deleteSales() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_sales WHERE sale_id = " + sales.getSales_id()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the sales detail
    public void loadSales() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_sales WHERE sale_id = "+sales.getSales_id());
          while(rs.next()){
            sales = new SalesOF(rs.getInt("sale_id"), rs.getString("sale_customer_name"), rs.getString("sale_customer_address"), rs.getString("sale_date"), rs.getInt("sale_bill_no"), rs.getInt("sale_rate"), rs.getInt("sale_quantity"), rs.getInt("item_id"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to list the saless
    public ArrayList<SalesOF> getSalesList() throws Exception{
    saless = new ArrayList<SalesOF>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT s.*, i.item_name FROM tbl_item i INNER JOIN tbl_sales s ON i.item_id = s.item_id ORDER BY s.sale_id");
          while(rs.next()){        
            sales = new SalesOF(rs.getInt("sale_id"), rs.getString("sale_customer_name"), rs.getString("sale_customer_address"), rs.getString("sale_date"), rs.getInt("sale_bill_no"), rs.getInt("sale_rate"), rs.getInt("sale_quantity"), rs.getInt("item_id"));
            sales.setItem_name(rs.getString("item_name"));
            saless.add(sales);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return saless;
    }
    
    // Function to search the saless
   public ArrayList<SalesOF> searchSales() throws Exception{
       
        String filterCustoName = sales.getSales_customer_name();  
            int filterSalesId =sales.getSales_id();
            String sqry = "";
            saless = new ArrayList<SalesOF>();
            try{
              this.connect();
              Statement s = this.conn.createStatement();
              String sql1 ="SELECT s.sale_id,s.sale_customer_name,s.sale_customer_address,s.sale_date,s.sale_bill_no,s.sale_rate,s.sale_quantity,i.item_name FROM tbl_sales s LEFT JOIN tbl_item i ON s.item_id=i.item_id";

            if (filterCustoName.equals("")) {
              sql1=sql1;               
            } else {
                sql1 += " where s.sale_customer_name LIKE '%" + filterCustoName + "%'";
            }      
        //ResultSet rs = s.executeQuery("SELECT c.customer_Id,c.customer_Name,c.sur_Name,c.designation_Title,c.address,c.mobile,c.register_Date, d.court_Name FROM customer c LEFT JOIN court d ON c.court_id=d.court_Id"+sqry+" ORDER BY c.customer_Name ");
            ResultSet rs = s.executeQuery(sql1);
            while(rs.next()){
                    sales=new SalesOF();      
                    sales.setSales_id(rs.getInt("s.sale_id"));
                    sales.setSales_customer_name(rs.getString("s.sale_customer_name"));
                    sales.setSales_customer_address(rs.getString("s.sale_customer_address"));                    
                    sales.setSales_date(rs.getString("s.sale_date"));  
                    sales.setSales_bill_no(rs.getInt("s.sale_bill_no")); 
                    sales.setSales_rate(rs.getInt("s.sale_rate")); 
                    sales.setSales_quantity(rs.getInt("s.sale_quantity"));
                    sales.setItem_name(rs.getString("i.item_name"));
                saless.add(sales);
                }
                    this.disconnect();
                }catch(Exception ex){
                    throw ex;
                }
            return saless;
   
    }
}
