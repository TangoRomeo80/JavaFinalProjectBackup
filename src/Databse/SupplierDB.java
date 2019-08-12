package Databse;

import Object.SupplierObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to define supplier related interactions with db
 */
public class SupplierDB extends GlobalConnection {
    
    private SupplierObj supplier;
    private ArrayList<SupplierObj> suppliers;
    
    public SupplierDB() {
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
    
    // Function to insert the supplier in supplier table 
    public boolean insertsupplier() throws Exception{
      try{
          return this.insert("INSERT INTO tbl_supplier ( supplierName, supplierPhone, supplierAddress, supplierDetail ) VALUES ('"+supplier.getsupplierName()+"','"+supplier.getsupplierPhone()+"','"+supplier.getsupplierAddress()+"','"+supplier.getsupplierDetail()+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the supplier in supplier table
    public boolean updatesupplier() throws Exception{
      try{
          return this.update("UPDATE tbl_supplier SET supplierName='"+supplier.getsupplierName()+"', supplierPhone='"+supplier.getsupplierPhone()+"', supplierAddress='"+supplier.getsupplierAddress()+"', supplierDetail='"+supplier.getsupplierDetail()+"'  WHERE supplierId = " + supplier.getsupplierId());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the supplier in supplier table
    public boolean deletesupplier() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_supplier WHERE supplierId = " + supplier.getsupplierId()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the supplier detail
    public void loadsupplier() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_supplier WHERE supplierId = "+supplier.getsupplierId());
          while(rs.next()){
            supplier = new SupplierObj(rs.getInt("supplierId"), rs.getString("supplierName"), rs.getString("supplierPhone"), rs.getString("supplierAddress"), rs.getString("supplierDetail"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
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
    
    // Function to search the suppliers
    public ArrayList<SupplierObj> searchsupplier() throws Exception{
    String filterSupplierName = supplier.getsupplierName();
    int filterSupplierId = supplier.getsupplierId();
    String sqry = "";
    suppliers = new ArrayList<SupplierObj>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          if(!"".equals(filterSupplierName)){
            sqry = "supplierName LIKE '%" + filterSupplierName +"%' ";
          }
          if(filterSupplierId > 0){
            if("".equals(sqry))
              sqry = "supplierId = '"+ filterSupplierId+"' ";
            else
              sqry = sqry + " AND supplierId = '"+ filterSupplierId+"' ";
          }
          if(!"".equals(sqry)) sqry = "WHERE "+sqry;
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_supplier "+sqry+" ORDER BY supplierName ");
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
