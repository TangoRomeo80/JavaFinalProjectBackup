/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.SupplierDl;
import ObjectFactory.SupplierOF;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class SupplierBl {
    private SupplierDl SupplierDl;
    private SupplierOF supplier;
  
  public SupplierBl() {
    supplier = new SupplierOF();
    SupplierDl = new SupplierDl();
  }

  public SupplierBl(SupplierOF supplier) {
    this.supplier = supplier;
    this.SupplierDl = new SupplierDl();
  }

  public SupplierOF getsupplier() {
    return supplier;
  }

  public void setsupplier(SupplierOF supplier) {
    this.supplier = supplier;
  }
  
//  public boolean authenticatesupplier() throws Exception{
//    try{
//      SupplierDl.setsupplier(supplier);
//      if(SupplierDl.authenticatesupplier()){
//        SupplierDl.loadsupplier();
//        supplier = SupplierDl.getsupplier();
//        return true;
//      }
//    }catch( Exception ex){
//      throw ex;
//    }
//    return false;
//  }
//  
  public boolean insertsupplier() throws Exception{
    try{
      SupplierDl.setsupplier(supplier);
      return SupplierDl.insertsupplier();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean updatesupplier() throws Exception{
    try{
      SupplierDl.setsupplier(supplier);
      return SupplierDl.updatesupplier();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean deletesupplier() throws Exception{
    try{
      SupplierDl.setsupplier(supplier);
      return SupplierDl.deletesupplier();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<SupplierOF> getsupplierList() throws Exception{
    try{
      return SupplierDl.getsupplierList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<SupplierOF> searchsupplier() throws Exception{
    try{
      SupplierDl.setsupplier(supplier);
      return SupplierDl.searchsupplier();
    }catch(Exception ex){
      throw ex;
    }
  } 
  
  
}
