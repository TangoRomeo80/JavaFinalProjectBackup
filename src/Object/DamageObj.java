package Object;

/**
 *
 * @author Rahat
 * Class to keep track of the damage registry
 */
public class DamageObj {
    
    private int damageId;
    private String damageName;
    private int damagQuantity;
    private String damageQuantity;
    private String damageDetail;
    private int itemId;
    String itemName;
    
    public DamageObj(){
    
        this.damageId       = 0;
        this.damageName     = "";
        this.damageName     = "";
        this.damagQuantity = 0;
        this.damageQuantity     = "";
        this.damageDetail   = "";
        this.itemId         = 0;
        this.itemName       = "";
        
    }
    
    public DamageObj( int damageId, String damageName, int damagQuantity, String damageQuantity, String damageDetail, int itemId ){
        this.damageId       = damageId;
        this.damageName     = damageName;
        this.damagQuantity = damagQuantity;
        this.damageQuantity     = damageQuantity;
        this.damageDetail   = damageDetail;
        this.itemId         = itemId;
    
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

    public String getDamageDate() {
        return damageQuantity;
    }

    public void setDamageDate(String damageQuantity) {
        this.damageQuantity = damageQuantity;
    }

    public String getDamageDetail() {
        return damageDetail;
    }

    public void setDamageDetail(String damageDetail) {
        this.damageDetail = damageDetail;
    }

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
        return damagQuantity;
    }

    public void setDamageQuantity(int damagQuantity) {
        this.damagQuantity = damagQuantity;
    }
    
}
