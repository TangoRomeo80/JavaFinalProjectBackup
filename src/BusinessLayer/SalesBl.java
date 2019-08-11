/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.SalesDl;
import ObjectFactory.SalesOF;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class SalesBl {
    
  private SalesDl salesDl;
  private SalesOF sales;
  
  public SalesBl() {
    sales = new SalesOF();
    salesDl = new SalesDl();
  }
  
  public SalesBl(SalesOF sale) {
    this.sales = sale;
    this.salesDl = new SalesDl();
  }
  
  public SalesOF getsale() {
    return sales;
  }

  public void setsale(SalesOF sale) {
    this.sales = sale;
  }
  
  public boolean insertSales() throws Exception{
    try{
      salesDl.setSales(sales);
      return salesDl.insertSales();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean updateSales() throws Exception{
    try{
      salesDl.setSales(sales);
      return salesDl.updateSales();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean deleteSales() throws Exception{
    try{
      salesDl.setSales(sales);
      return salesDl.deleteSales();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<SalesOF> getSalesList() throws Exception{
    try{
      return salesDl.getSalesList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<SalesOF> searchSales() throws Exception{
    try{
      salesDl.setSales(sales);
      return salesDl.searchSales();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
