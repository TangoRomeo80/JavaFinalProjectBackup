/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectFactory;

/**
 *
 * @author chhabi
 */
public class ItemOF {
    
    private int     item_id;
    private String  item_name;
    private int     item_rate;
    private int     item_quantity;
    private String  item_order_date;
    private String  item_supplied_date;
    private String  item_detail;
    private int     cat_id;
    private int     supplier_id;
    String  cat_name;
    String  supplier_name;
    
    public ItemOF(){
        this.item_id            = 0;
        this.item_name          = "";
        this.item_rate          = 0;
        this.item_quantity      = 0;
        this.item_order_date    = "";
        this.item_supplied_date = "";
        this.item_detail        = "";
        this.cat_id             = 0;
        this.supplier_id        = 0;
        this.cat_name           = "";
        this.supplier_name      = "";
    }
    
    public ItemOF( int item_id, String item_name, int item_rate, int item_quantity, String item_order_date, String item_supplied_date, String item_detail, int cat_id, int supplier_id  ){
        this.item_id            = item_id;
        this.item_name          = item_name;
        this.item_rate          = item_rate;
        this.item_quantity      = item_quantity;
        this.item_order_date    = item_order_date;
        this.item_supplied_date = item_supplied_date;
        this.item_detail        = item_detail;
        this.cat_id             = cat_id;
        this.supplier_id        = supplier_id;    
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }
    
    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getItem_detail() {
        return item_detail;
    }

    public void setItem_detail(String item_detail) {
        this.item_detail = item_detail;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_order_date() {
        return item_order_date;
    }

    public void setItem_order_date(String item_order_date) {
        this.item_order_date = item_order_date;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public int getItem_rate() {
        return item_rate;
    }

    public void setItem_rate(int item_rate) {
        this.item_rate = item_rate;
    }

    public String getItem_supplied_date() {
        return item_supplied_date;
    }

    public void setItem_supplied_date(String item_supplied_date) {
        this.item_supplied_date = item_supplied_date;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }
    
}
