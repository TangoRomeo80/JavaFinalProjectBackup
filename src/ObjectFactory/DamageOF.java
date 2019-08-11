/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectFactory;

/**
 *
 * @author chhabi
 */
public class DamageOF {
    
    private int damage_id;
    private String damage_name;
    private int damage_quantity;
    private String damage_date;
    private String damage_detail;
    private int item_id;
    String item_name;
    
    public DamageOF(){
    
        this.damage_id       = 0;
        this.damage_name     = "";
        this.damage_name     = "";
        this.damage_quantity = 0;
        this.damage_date     = "";
        this.damage_detail   = "";
        this.item_id         = 0;
        this.item_name       = "";
        
    }
    
    public DamageOF( int damage_id, String damage_name, int damage_quantity, String damage_date, String damage_detail, int item_id ){
        this.damage_id       = damage_id;
        this.damage_name     = damage_name;
        this.damage_quantity = damage_quantity;
        this.damage_date     = damage_date;
        this.damage_detail   = damage_detail;
        this.item_id         = item_id;
    
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getDamage_date() {
        return damage_date;
    }

    public void setDamage_date(String damage_date) {
        this.damage_date = damage_date;
    }

    public String getDamage_detail() {
        return damage_detail;
    }

    public void setDamage_detail(String damage_detail) {
        this.damage_detail = damage_detail;
    }

    public int getDamage_id() {
        return damage_id;
    }

    public void setDamage_id(int damage_id) {
        this.damage_id = damage_id;
    }

    public String getDamage_name() {
        return damage_name;
    }

    public void setDamage_name(String damage_name) {
        this.damage_name = damage_name;
    }

    public int getDamage_quantity() {
        return damage_quantity;
    }

    public void setDamage_quantity(int damage_quantity) {
        this.damage_quantity = damage_quantity;
    }
    
}
