/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.ItemOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportItemDl extends GlobalConnection{
    
    private ItemOF item;
    private ArrayList<ItemOF> items;
    
    public ReportItemDl() {
        super();
        item  = new ItemOF();
        items = new ArrayList<ItemOF>();
    }
    
    public ItemOF getitem() {
        return item;
    }

    public void setitem(ItemOF item) {
        this.item = item;
    }
    
    // Function to list the items
    public ArrayList<ItemOF> getItemList() throws Exception{
    items = new ArrayList<ItemOF>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          // Join query to display category name and supplier name in item table 
          ResultSet rs = s.executeQuery("SELECT i.*, c.cat_name, s.supplier_name FROM tbl_item i INNER JOIN tbl_category c ON c.cat_id = i.cat_id INNER JOIN tbl_supplier s ON s.supplier_id = i.supplier_id ORDER BY i.item_id");
         
          while(rs.next()){        
            item = new ItemOF(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("item_rate"), rs.getInt("item_quantity"), rs.getString("item_order_date"), rs.getString("item_supplied_date"), rs.getString("item_detail"),rs.getInt("cat_id"),rs.getInt("supplier_id"));
            item.setCat_name(rs.getString("cat_name")); 
            item.setSupplier_name(rs.getString("supplier_name"));
            items.add(item);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return items;
    }
    
}
