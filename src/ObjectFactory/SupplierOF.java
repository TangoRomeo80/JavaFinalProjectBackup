/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectFactory;

/**
 *
 * @author chhabi
 */
public class SupplierOF {
    
    private int     supplier_id;
    private String  supplier_name;
    private String  supplier_phone;
    private String  supplier_address;
    private String  supplier_detail;
    
    public SupplierOF(){
        this.supplier_id      = 0;
        this.supplier_name    = "";
        this.supplier_phone   = "";
        this.supplier_address = "";
        this.supplier_detail  = "";
    }
    
       public SupplierOF( int supplier_id, String supplier_name, String supplier_phone, String supplier_address, String supplier_detail ){
            this.supplier_id      = supplier_id;
            this.supplier_name    = supplier_name;
            this.supplier_phone   = supplier_phone;
            this.supplier_address = supplier_address;
            this.supplier_detail  = supplier_detail;
        }

    public String getSupplier_address() {
        return supplier_address;
    }

    public void setSupplier_address(String supplier_address) {
        this.supplier_address = supplier_address;
    }

    public String getSupplier_detail() {
        return supplier_detail;
    }

    public void setSupplier_detail(String supplier_detail) {
        this.supplier_detail = supplier_detail;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_phone() {
        return supplier_phone;
    }

    public void setSupplier_phone(String supplier_phone) {
        this.supplier_phone = supplier_phone;
    }
       
}
