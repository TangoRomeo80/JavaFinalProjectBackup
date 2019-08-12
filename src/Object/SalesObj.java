package Object;

/**
 *
 * @author Rahat
 * class to define sales items
 */
public class SalesObj {
    
    private int     salesId;
    private String  salesCustomerName;
    private String  salesCustomerAddress;
    private String  salesDate;
    private int     salesBillNo;
    private int     salesRate;
    private int     salesQuantity;
    private int     itemId;
    String          itemName;
    
    public SalesObj(){
        this.salesId                = 0;
        this.salesCustomerName     = "";
        this.salesCustomerAddress  = "";
        this.salesDate              = "";
        this.salesBillNo           = 0;
        this.salesRate              = 0;
        this.salesQuantity          = 0;        
        this.itemId                 = 0;
        this.itemName               = "";   
    }    
    
    public SalesObj( int salesId, String salesCustomerName, String salesCustomerAddress, String salesDate, int salesBillNo, int salesRate, int salesQuantity, int itemId ){
        this.salesId                = salesId;
        this.salesCustomerName     = salesCustomerName;
        this.salesCustomerAddress  = salesCustomerAddress;
        this.salesDate              = salesDate;
        this.salesBillNo           = salesBillNo;
        this.salesRate              = salesRate;
        this.salesQuantity          = salesQuantity; 
        this.itemId                 = itemId;
    }

    public String getitemName() {
        return itemName;
    }

    public void setitemName(String itemName) {
        this.itemName = itemName;
    }
    
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getsalesBillNo() {
        return salesBillNo;
    }

    public void setsalesBillNo(int salesBillNo) {
        this.salesBillNo = salesBillNo;
    }

    public String getsalesCustomerAddress() {
        return salesCustomerAddress;
    }

    public void setsalesCustomerAddress(String salesCustomerAddress) {
        this.salesCustomerAddress = salesCustomerAddress;
    }

    public String getsalesCustomerName() {
        return salesCustomerName;
    }

    public void setsalesCustomerName(String salesCustomerName) {
        this.salesCustomerName = salesCustomerName;
    }

    public String getsalesDate() {
        return salesDate;
    }

    public void setsalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public int getsalesId() {
        return salesId;
    }

    public void setsalesId(int salesId) {
        this.salesId = salesId;
    }

    public int getsalesQuantity() {
        return salesQuantity;
    }

    public void setsalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public int getsalesRate() {
        return salesRate;
    }

    public void setsalesRate(int salesRate) {
        this.salesRate = salesRate;
    }
        
}