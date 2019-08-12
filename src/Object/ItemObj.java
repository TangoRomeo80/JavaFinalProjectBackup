package Object;

/**
 *
 * @author Rahat
 * Class to define the items 
 */
public class ItemObj {
    
    private int     itemId;
    private String  itemName;
    private int     itemRate;
    private int     itemQuantity;
    private String  itemOrderDate;
    private String  itemSuppliedDate;
    private String  itemDetail;
    private int     catId;
    private int     supplierId;
    String  catName;
    String  supplierName;
    
    public ItemObj(){
        this.itemId            = 0;
        this.itemName          = "";
        this.itemRate          = 0;
        this.itemQuantity      = 0;
        this.itemOrderDate    = "";
        this.itemSuppliedDate = "";
        this.itemDetail        = "";
        this.catId             = 0;
        this.supplierId        = 0;
        this.catName           = "";
        this.supplierName      = "";
    }
    
    public ItemObj( int itemId, String itemName, int itemRate, int itemQuantity, String itemOrderDate, String itemSuppliedDate, String itemDetail, int catId, int supplierId  ){
        this.itemId            = itemId;
        this.itemName          = itemName;
        this.itemRate          = itemRate;
        this.itemQuantity      = itemQuantity;
        this.itemOrderDate    = itemOrderDate;
        this.itemSuppliedDate = itemSuppliedDate;
        this.itemDetail        = itemDetail;
        this.catId             = catId;
        this.supplierId        = supplierId;    
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getsupplierName() {
        return supplierName;
    }

    public void setsupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getitemDetail() {
        return itemDetail;
    }

    public void setitemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
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

    public String getitemOrderDate() {
        return itemOrderDate;
    }

    public void setitemOrderDate(String itemOrderDate) {
        this.itemOrderDate = itemOrderDate;
    }

    public int getitemQuantity() {
        return itemQuantity;
    }

    public void setitemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getitemRate() {
        return itemRate;
    }

    public void setitemRate(int itemRate) {
        this.itemRate = itemRate;
    }

    public String getitemSuppliedDate() {
        return itemSuppliedDate;
    }

    public void setitemSuppliedDate(String itemSuppliedDate) {
        this.itemSuppliedDate = itemSuppliedDate;
    }

    public int getsupplierId() {
        return supplierId;
    }

    public void setsupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    
}
