package Object;

/**
 *
 * @author Rahat
 * class to define the properties of a returned item
 */
public class ReportReturnObj {
    private int returnId;
    private int returnQuantity;
    private String returnDate;
    private int itemId;
    private String itemName;

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

    public String getreturnDate() {
        return returnDate;
    }

    public void setreturnDate(String returnDate) {
        this.returnDate = returnDate;
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
