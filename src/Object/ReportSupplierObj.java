package Object;

/**
 *
 * @author Rahat
 * class to define report about suppliers
 */
public class ReportSupplierObj {
    private int     supplierId;
    private String  supplierName;
    private String  supplierPhone;
    private String  supplierAddress;
    private String  supplierDetail;

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
    
}
