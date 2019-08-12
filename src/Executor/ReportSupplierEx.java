package Executor;

import Databse.SupplierDB;
import Object.SupplierObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for supplier report class
 */
public class ReportSupplierEx {
    
     private SupplierDB SupplierDl;
    private SupplierObj supplier;
  
  public ReportSupplierEx() {
    supplier = new SupplierObj();
    SupplierDl = new SupplierDB();
  }

  public ReportSupplierEx(SupplierObj supplier) {
    this.supplier = supplier;
    this.SupplierDl = new SupplierDB();
  }

  public SupplierObj getsupplier() {
    return supplier;
  }

  public void setsupplier(SupplierObj supplier) {
    this.supplier = supplier;
  }
  
  public ArrayList<SupplierObj> getsupplierList() throws Exception{
    try{
      return SupplierDl.getsupplierList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
