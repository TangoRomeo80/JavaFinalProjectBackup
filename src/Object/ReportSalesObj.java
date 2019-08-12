package Object;

/**
 *
 * @author Rahat
 * class to define report about sales items
 */
public class ReportSalesObj {
    
    private int     salesId;
    private String  salesCustomerName;
    private String  salesCustomerAddress;
    private String  salesDate;
    private int     salesBillNo;
    private int     salesRate;
    private int     salesQuantity;
    private int     itemId;
    String          itemName;

    public int getsalesId() {
        return salesId;
    }

    public void setsalesId(int salesId) {
        this.salesId = salesId;
    }

    public String getsalesCustomerName() {
        return salesCustomerName;
    }

    public void setsalesCustomerName(String salesCustomerName) {
        this.salesCustomerName = salesCustomerName;
    }

    public String getsalesCustomerAddress() {
        return salesCustomerAddress;
    }

    public void setsalesCustomerAddress(String salesCustomerAddress) {
        this.salesCustomerAddress = salesCustomerAddress;
    }

    public String getsalesDate() {
        return salesDate;
    }

    public void setsalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public int getsalesBillNo() {
        return salesBillNo;
    }

    public void setsalesBillNo(int salesBillNo) {
        this.salesBillNo = salesBillNo;
    }

    public int getsalesRate() {
        return salesRate;
    }

    public void setsalesRate(int salesRate) {
        this.salesRate = salesRate;
    }

    public int getsalesQuantity() {
        return salesQuantity;
    }

    public void setsalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getitemName() {
        return itemName;
    }

    public void setitemName(String itemName) {
        this.itemName = itemName;
    }
    
}
