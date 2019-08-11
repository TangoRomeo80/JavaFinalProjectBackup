/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectFactory;

/**
 *
 * @author chhabi
 */
public class ReturnOF {
    
    private int return_id;
    private String return_name;
    private int return_quantity;
    private String return_date;
    private int item_id;
    private String item_name;
    
    public ReturnOF(){
        this.return_id       = 0;
        this.return_name     = "";
        this.return_quantity = 0;
        this.return_date     = "";        
        this.item_id         = 0;
        this.item_name       = "";
        
    }
    
    public ReturnOF( int return_id, String return_name, int return_quantity, String return_date, int item_id){
        this.return_id       = return_id;
        this.return_name     = return_name;
        this.return_quantity = return_quantity;
        this.return_date     = return_date;
        this.item_id         = item_id;
    }

    public String getReturn_name() {
        return return_name;
    }

    public void setReturn_name(String return_name) {
        this.return_name = return_name;
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

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public int getReturn_id() {
        return return_id;
    }

    public void setReturn_id(int return_id) {
        this.return_id = return_id;
    }

    public int getReturn_quantity() {
        return return_quantity;
    }

    public void setReturn_quantity(int return_quantity) {
        this.return_quantity = return_quantity;
    }
    
}
