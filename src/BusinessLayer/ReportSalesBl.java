/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.SalesDl;
import ObjectFactory.SalesOF;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportSalesBl {
   private SalesDl salesDl;
  private SalesOF sales;
  
  public ReportSalesBl() {
    sales = new SalesOF();
    salesDl = new SalesDl();
  }
  
  public ReportSalesBl(SalesOF sale) {
    this.sales = sale;
    this.salesDl = new SalesDl();
  }
  
  public SalesOF getsale() {
    return sales;
  }

  public void setsale(SalesOF sale) {
    this.sales = sale;
  }
  
  public ArrayList<SalesOF> getSalesList() throws Exception{
    try{
      return salesDl.getSalesList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
