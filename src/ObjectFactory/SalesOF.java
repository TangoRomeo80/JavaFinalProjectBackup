/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectFactory;

/**
 *
 * @author chhabi
 */
public class SalesOF {
    
    private int     sales_id;
    private String  sales_customer_name;
    private String  sales_customer_address;
    private String  sales_date;
    private int     sales_bill_no;
    private int     sales_rate;
    private int     sales_quantity;
    private int     item_id;
    String          item_name;
    
    public SalesOF(){
        this.sales_id                = 0;
        this.sales_customer_name     = "";
        this.sales_customer_address  = "";
        this.sales_date              = "";
        this.sales_bill_no           = 0;
        this.sales_rate              = 0;
        this.sales_quantity          = 0;        
        this.item_id                 = 0;
        this.item_name               = "";   
    }    
    
    public SalesOF( int sales_id, String sales_customer_name, String sales_customer_address, String sales_date, int sales_bill_no, int sales_rate, int sales_quantity, int item_id ){
        this.sales_id                = sales_id;
        this.sales_customer_name     = sales_customer_name;
        this.sales_customer_address  = sales_customer_address;
        this.sales_date              = sales_date;
        this.sales_bill_no           = sales_bill_no;
        this.sales_rate              = sales_rate;
        this.sales_quantity          = sales_quantity; 
        this.item_id                 = item_id;
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

    public int getSales_bill_no() {
        return sales_bill_no;
    }

    public void setSales_bill_no(int sales_bill_no) {
        this.sales_bill_no = sales_bill_no;
    }

    public String getSales_customer_address() {
        return sales_customer_address;
    }

    public void setSales_customer_address(String sales_customer_address) {
        this.sales_customer_address = sales_customer_address;
    }

    public String getSales_customer_name() {
        return sales_customer_name;
    }

    public void setSales_customer_name(String sales_customer_name) {
        this.sales_customer_name = sales_customer_name;
    }

    public String getSales_date() {
        return sales_date;
    }

    public void setSales_date(String sales_date) {
        this.sales_date = sales_date;
    }

    public int getSales_id() {
        return sales_id;
    }

    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    public int getSales_quantity() {
        return sales_quantity;
    }

    public void setSales_quantity(int sales_quantity) {
        this.sales_quantity = sales_quantity;
    }

    public int getSales_rate() {
        return sales_rate;
    }

    public void setSales_rate(int sales_rate) {
        this.sales_rate = sales_rate;
    }
        
}