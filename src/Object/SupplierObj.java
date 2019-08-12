package Object;

/**
 *
 * @author Rahat
 * class to define supplier informations
 */
public class SupplierObj {
    
    private int     supplierId;
    private String  supplierName;
    private String  supplierPhone;
    private String  supplierAddress;
    private String  supplierDetail;
    
    public SupplierObj(){
        this.supplierId      = 0;
        this.supplierName    = "";
        this.supplierPhone   = "";
        this.supplierAddress = "";
        this.supplierDetail  = "";
    }
    
       public SupplierObj( int supplierId, String supplierName, String supplierPhone, String supplierAddress, String supplierDetail ){
            this.supplierId      = supplierId;
            this.supplierName    = supplierName;
            this.supplierPhone   = supplierPhone;
            this.supplierAddress = supplierAddress;
            this.supplierDetail  = supplierDetail;
        }

    public String getsupplierAddress() {
        return supplierAddress;
    }

    public void setsupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getsupplierDetail() {
        return supplierDetail;
    }

    public void setsupplierDetail(String supplierDetail) {
        this.supplierDetail = supplierDetail;
    }

    public int getsupplierId() {
        return supplierId;
    }

    public void setsupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getsupplierName() {
        return supplierName;
    }

    public void setsupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getsupplierPhone() {
        return supplierPhone;
    }

    public void setsupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }
       
}
