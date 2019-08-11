/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.SupplierOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportSupplierDl extends GlobalConnection {
    
    private SupplierOF supplier;
    private ArrayList<SupplierOF> suppliers;
    
    public ReportSupplierDl() {
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
    
}
