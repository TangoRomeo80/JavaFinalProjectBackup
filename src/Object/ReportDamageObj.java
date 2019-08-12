package Object;

/**
 *
 * @author Rahat
 * class to define damage report
 */
public class ReportDamageObj {
    
    private int damageId;
    private String damageName;
    private int damageQuantity;
    private String damageDate;
    private String damageDetail;
    private int itemId;
    String itemName;

    public int getDamageId() {
        return damageId;
    }

    public void setDamageId(int damageId) {
        this.damageId = damageId;
    }

    public String getDamageName() {
        return damageName;
    }

    public void setDamageName(String damageName) {
        this.damageName = damageName;
    }

    public int getDamageQuantity() {
        return damageQuantity;
    }

    public void setDamageQuantity(int damageQuantity) {
        this.damageQuantity = damageQuantity;
    }

    public String getDamageDate() {
        return damageDate;
    }

    public void setDamageDate(String damageDate) {
        this.damageDate = damageDate;
    }

    public String getdamageId() {
        return damageDetail;
    }

    public void setdamageId(String damageDetail) {
        this.damageDetail = damageDetail;
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
