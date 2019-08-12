package Databse;

import Object.SupplierObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * 
 */
public class ReportSupplierDB extends GlobalConnection {
    
    private SupplierObj supplier;
    private ArrayList<SupplierObj> suppliers;
    
    public ReportSupplierDB() {
        super();
        supplier = new SupplierObj();
        suppliers = new ArrayList<SupplierObj>();
    }
    
    public SupplierObj getsupplier() {
        return supplier;
    }

    public void setsupplier(SupplierObj supplier) {
        this.supplier = supplier;
    }
    
    // Function to list the suppliers
    public ArrayList<SupplierObj> getsupplierList() throws Exception{
    suppliers = new ArrayList<SupplierObj>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_supplier ORDER BY supplierId ");
          while(rs.next()){        
            supplier = new SupplierObj(rs.getInt("supplierId"), rs.getString("supplierName"), rs.getString("supplierPhone"), rs.getString("supplierAddress"), rs.getString("supplierDetail"));
            suppliers.add(supplier);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return suppliers;
    }
    
}
