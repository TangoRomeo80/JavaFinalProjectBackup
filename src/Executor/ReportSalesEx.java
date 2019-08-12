package Executor;

import Databse.SalesDB;
import Object.SalesObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for sales report class
 */
public class ReportSalesEx {
   private SalesDB salesDl;
  private SalesObj sales;
  
  public ReportSalesEx() {
    sales = new SalesObj();
    salesDl = new SalesDB();
  }
  
  public ReportSalesEx(SalesObj sale) {
    this.sales = sale;
    this.salesDl = new SalesDB();
  }
  
  public SalesObj getsale() {
    return sales;
  }

  public void setsale(SalesObj sale) {
    this.sales = sale;
  }
  
  public ArrayList<SalesObj> getSalesList() throws Exception{
    try{
      return salesDl.getSalesList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
