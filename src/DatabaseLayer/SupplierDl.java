/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.SupplierOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class SupplierDl extends GlobalConnection {
    
    private SupplierOF supplier;
    private ArrayList<SupplierOF> suppliers;
    
    public SupplierDl() {
        super();
        supplier = new SupplierOF();
        suppliers = new ArrayList<SupplierOF>();
    }
    
    public SupplierOF getsupplier() {
        return supplier;
    }

    public void setsupplier(SupplierOF supplier) {
        this.supplier = supplier;
    }
    
    // Function to insert the supplier in supplier table 
    public boolean insertsupplier() throws Exception{
      try{
          return this.insert("INSERT INTO tbl_supplier ( supplier_name, supplier_phone, supplier_address, supplier_detail ) VALUES ('"+supplier.getSupplier_name()+"','"+supplier.getSupplier_phone()+"','"+supplier.getSupplier_address()+"','"+supplier.getSupplier_detail()+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the supplier in supplier table
    public boolean updatesupplier() throws Exception{
      try{
          return this.update("UPDATE tbl_supplier SET supplier_name='"+supplier.getSupplier_name()+"', supplier_phone='"+supplier.getSupplier_phone()+"', supplier_address='"+supplier.getSupplier_address()+"', supplier_detail='"+supplier.getSupplier_detail()+"'  WHERE supplier_id = " + supplier.getSupplier_id());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the supplier in supplier table
    public boolean deletesupplier() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_supplier WHERE supplier_id = " + supplier.getSupplier_id()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the supplier detail
    public void loadsupplier() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_supplier WHERE supplier_id = "+supplier.getSupplier_id());
          while(rs.next()){
            supplier = new SupplierOF(rs.getInt("supplier_id"), rs.getString("supplier_name"), rs.getString("supplier_phone"), rs.getString("supplier_address"), rs.getString("supplier_detail"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to list the suppliers
    public ArrayList<SupplierOF> getsupplierList() throws Exception{
    suppliers = new ArrayList<SupplierOF>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_supplier ORDER BY supplier_id ");
          while(rs.next()){        
            supplier = new SupplierOF(rs.getInt("supplier_id"), rs.getString("supplier_name"), rs.getString("supplier_phone"), rs.getString("supplier_address"), rs.getString("supplier_detail"));
            suppliers.add(supplier);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return suppliers;
    }
    
    // Function to search the suppliers
    public ArrayList<SupplierOF> searchsupplier() throws Exception{
    String filterSupplierName = supplier.getSupplier_name();
    int filterSupplierId = supplier.getSupplier_id();
    String sqry = "";
    suppliers = new ArrayList<SupplierOF>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          if(!"".equals(filterSupplierName)){
            sqry = "supplier_name LIKE '%" + filterSupplierName +"%' ";
          }
          if(filterSupplierId > 0){
            if("".equals(sqry))
              sqry = "supplier_id = '"+ filterSupplierId+"' ";
            else
              sqry = sqry + " AND supplier_id = '"+ filterSupplierId+"' ";
          }
          if(!"".equals(sqry)) sqry = "WHERE "+sqry;
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_supplier "+sqry+" ORDER BY supplier_name ");
          while(rs.next()){ 
            supplier = new SupplierOF(rs.getInt("supplier_id"), rs.getString("supplier_name"), rs.getString("supplier_phone"), rs.getString("supplier_address"), rs.getString("supplier_detail"));
            suppliers.add(supplier);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return suppliers;
     }
    
}
