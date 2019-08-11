/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.SupplierDl;
import ObjectFactory.SupplierOF;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportSupplierBl {
    
     private SupplierDl SupplierDl;
    private SupplierOF supplier;
  
  public ReportSupplierBl() {
    supplier = new SupplierOF();
    SupplierDl = new SupplierDl();
  }

  public ReportSupplierBl(SupplierOF supplier) {
    this.supplier = supplier;
    this.SupplierDl = new SupplierDl();
  }

  public SupplierOF getsupplier() {
    return supplier;
  }

  public void setsupplier(SupplierOF supplier) {
    this.supplier = supplier;
  }
  
  public ArrayList<SupplierOF> getsupplierList() throws Exception{
    try{
      return SupplierDl.getsupplierList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
