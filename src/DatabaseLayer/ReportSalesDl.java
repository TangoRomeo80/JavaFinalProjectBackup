/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.SalesOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportSalesDl extends GlobalConnection{
    
    private SalesOF sales;
    private ArrayList<SalesOF> saless;
    
    public ReportSalesDl() {
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
    
}
