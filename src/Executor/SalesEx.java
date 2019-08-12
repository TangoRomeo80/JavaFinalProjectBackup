package Executor;

import Databse.SalesDB;
import Object.SalesObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for sales class
 */
public class SalesEx {
    
  private SalesDB salesDl;
  private SalesObj sales;
  
  public SalesEx() {
    sales = new SalesObj();
    salesDl = new SalesDB();
  }
  
  public SalesEx(SalesObj sale) {
    this.sales = sale;
    this.salesDl = new SalesDB();
  }
  
  public SalesObj getsale() {
    return sales;
  }

  public void setsale(SalesObj sale) {
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
  
  public ArrayList<SalesObj> getSalesList() throws Exception{
    try{
      return salesDl.getSalesList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<SalesObj> searchSales() throws Exception{
    try{
      salesDl.setSales(sales);
      return salesDl.searchSales();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
