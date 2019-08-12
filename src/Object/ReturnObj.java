package Object;

/**
 *
 * @author Rahat
 * class to track returned items
 */
public class ReturnObj {
    
    private int returnId;
    private String returnName;
    private int returnQuantity;
    private String returnDate;
    private int itemId;
    private String itemName;
    
    public ReturnObj(){
        this.returnId       = 0;
        this.returnName     = "";
        this.returnQuantity = 0;
        this.returnDate     = "";        
        this.itemId         = 0;
        this.itemName       = "";
        
    }
    
    public ReturnObj( int returnId, String returnName, int returnQuantity, String returnDate, int itemId){
        this.returnId       = returnId;
        this.returnName     = returnName;
        this.returnQuantity = returnQuantity;
        this.returnDate     = returnDate;
        this.itemId         = itemId;
    }

    public String getreturnName() {
        return returnName;
    }

    public void setreturnName(String returnName) {
        this.returnName = returnName;
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

    public String getreturnDate() {
        return returnDate;
    }

    public void setreturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getreturnId() {
        return returnId;
    }

    public void setreturnId(int returnId) {
        this.returnId = returnId;
    }

    public int getreturnQuantity() {
        return returnQuantity;
    }

    public void setreturnQuantity(int returnQuantity) {
        this.returnQuantity = returnQuantity;
    }
    
}
