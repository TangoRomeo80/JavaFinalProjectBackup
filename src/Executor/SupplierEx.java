package Executor;

import Databse.SupplierDB;
import Object.SupplierObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for supplier class
 */
public class SupplierEx {
    private SupplierDB SupplierDl;
    private SupplierObj supplier;
  
  public SupplierEx() {
    supplier = new SupplierObj();
    SupplierDl = new SupplierDB();
  }

  public SupplierEx(SupplierObj supplier) {
    this.supplier = supplier;
    this.SupplierDl = new SupplierDB();
  }

  public SupplierObj getsupplier() {
    return supplier;
  }

  public void setsupplier(SupplierObj supplier) {
    this.supplier = supplier;
  }
  
//  public boolean authenticatesupplier() throws Exception{
//    try{
//      SupplierDB.setsupplier(supplier);
//      if(SupplierDB.authenticatesupplier()){
//        SupplierDB.loadsupplier();
//        supplier = SupplierDB.getsupplier();
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
  
  public ArrayList<SupplierObj> getsupplierList() throws Exception{
    try{
      return SupplierDl.getsupplierList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<SupplierObj> searchsupplier() throws Exception{
    try{
      SupplierDl.setsupplier(supplier);
      return SupplierDl.searchsupplier();
    }catch(Exception ex){
      throw ex;
    }
  } 
  
  
}
