package Object;

/**
 *
 * @author Rahat
 * class to define the report for items
 */
public class ReportItemObj {
    
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

    public int getitemRate() {
        return itemRate;
    }

    public void setitemRate(int itemRate) {
        this.itemRate = itemRate;
    }

    public int getitemQuantity() {
        return itemQuantity;
    }

    public void setitemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getitemOrderDate() {
        return itemOrderDate;
    }

    public void setitemOrderDate(String itemOrderDate) {
        this.itemOrderDate = itemOrderDate;
    }

    public String getitemSuppliedDate() {
        return itemSuppliedDate;
    }

    public void setitemSuppliedDate(String itemSuppliedDate) {
        this.itemSuppliedDate = itemSuppliedDate;
    }

    public String getitemDetail() {
        return itemDetail;
    }

    public void setitemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getsupplierId() {
        return supplierId;
    }

    public void setsupplierId(int supplierId) {
        this.supplierId = supplierId;
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
    
    
}
