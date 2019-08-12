package Databse;

import Object.ItemObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to define item report interaction with db
 */
public class ReportItemDB extends GlobalConnection{
    
    private ItemObj item;
    private ArrayList<ItemObj> items;
    
    public ReportItemDB() {
        super();
        item  = new ItemObj();
        items = new ArrayList<ItemObj>();
    }
    
    public ItemObj getitem() {
        return item;
    }

    public void setitem(ItemObj item) {
        this.item = item;
    }
    
    // Function to list the items
    public ArrayList<ItemObj> getItemList() throws Exception{
    items = new ArrayList<ItemObj>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          // Join query to display category name and supplier name in item table 
          ResultSet rs = s.executeQuery("SELECT i.*, c.catName, s.supplierName FROM tbl_item i INNER JOIN tbl_category c ON c.catId = i.catId INNER JOIN tbl_supplier s ON s.supplierId = i.supplierId ORDER BY i.itemId");
         
          while(rs.next()){        
            item = new ItemObj(rs.getInt("itemId"), rs.getString("itemName"), rs.getInt("itemRate"), rs.getInt("itemQuantity"), rs.getString("itemOrderDate"), rs.getString("itemSuppliedDate"), rs.getString("itemDetail"),rs.getInt("catId"),rs.getInt("supplierId"));
            item.setCatName(rs.getString("catName")); 
            item.setsupplierName(rs.getString("supplierName"));
            items.add(item);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return items;
    }
    
}
