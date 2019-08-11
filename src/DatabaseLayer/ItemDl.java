/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.ItemOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class ItemDl extends GlobalConnection{
    
    private ItemOF item;
    private ArrayList<ItemOF> items;
    
    public ItemDl() {
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
    
    // Function to insert the damage in damage table 
    public boolean insertItem() throws Exception{
      try{
          this.connect();
          // Convert category name to cat_id
          String iqry1  = ("SELECT cat_id FROM tbl_category where cat_name = '"+item.getCat_name()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int cate_id = 0;
          while(rs1.next()){
              cate_id = rs1.getInt("cat_id");
          }
          if(cate_id==0){
              throw new Exception("Select a Valid Category Name");
          }
          
          // Convert supplier name to supplier id
          String iqry2  = ("SELECT supplier_id FROM tbl_supplier where supplier_name = '"+item.getSupplier_name()+"' ");
          Statement s2  = this.conn.createStatement();
          ResultSet rs2 = s2.executeQuery(iqry2);
          int supp_id = 0;
          while(rs2.next()){
              supp_id = rs2.getInt("supplier_id");
          }
          if(supp_id==0){
              throw new Exception("Select a Valid Supplier Name");
          }
                    
          return this.insert("INSERT INTO tbl_item( item_name, item_rate, item_quantity, item_order_date, item_supplied_date, item_detail, cat_id, supplier_id ) VALUES ('"+item.getItem_name()+"','"+item.getItem_rate()+"','"+item.getItem_quantity()+"','"+item.getItem_order_date()+"','"+item.getItem_supplied_date()+"','"+item.getItem_detail()+"','"+cate_id+"','"+supp_id+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the damage in damage table
    public boolean updateItem() throws Exception{
      try{
           this.connect();
          // Convert category name to cat_id
          String iqry1  = ("SELECT cat_id FROM tbl_category where cat_name = '"+item.getCat_name()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int cate_id = 0;
          while(rs1.next()){
              cate_id = rs1.getInt("cat_id");
          }
          if(cate_id==0){
              throw new Exception("Select a Valid Category Name");
          }
          
          // Convert supplier name to supplier id
          String iqry2  = ("SELECT supplier_id FROM tbl_supplier where supplier_name = '"+item.getSupplier_name()+"' ");
          Statement s2  = this.conn.createStatement();
          ResultSet rs2 = s2.executeQuery(iqry2);
          int supp_id = 0;
          while(rs2.next()){
              supp_id = rs2.getInt("supplier_id");
          }
          if(supp_id==0){
              throw new Exception("Select a Valid Supplier Name");
          }
          
          return this.update("UPDATE tbl_item SET item_name='"+item.getItem_name()+"', item_rate='"+item.getItem_rate()+"', item_quantity='"+item.getItem_quantity()+"',item_order_date='"+item.getItem_order_date()+"',item_supplied_date='"+item.getItem_supplied_date()+"',item_detail='"+item.getItem_detail()+"',cat_id='"+cate_id+"',supplier_id='"+supp_id+"'  WHERE item_id = " + item.getItem_id());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the damage in damage table
    public boolean deleteItem() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_item WHERE item_id = " + item.getItem_id()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the damage detail
    public void loadItem() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();          
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_item WHERE item_id = "+item.getItem_id());
          while(rs.next()){
            item = new ItemOF(rs.getInt("item_id"), rs.getString("item_name"), rs.getInt("item_rate"), rs.getInt("item_quantity"), rs.getString("item_order_date"), rs.getString("item_supplied_date"), rs.getString("item_detail"),rs.getInt("category_id"),rs.getInt("supplier_id"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
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
    
    // Function to search the items
    public ArrayList<ItemOF> searchItem() throws Exception{
        String filterItemName = item.getItem_name();
        //int filterItemId = item.getItem_id();
        //String sqry = "";
        items = new ArrayList<ItemOF>();
            try{
              this.connect();
              Statement s = this.conn.createStatement();
              
              String sqry = "SELECT i.item_id,i.item_name,i.item_rate,i.item_quantity,i.item_order_date,i.item_supplied_date,i.item_detail ,c.cat_name,s.supplier_name FROM tbl_item i LEFT JOIN tbl_category c ON i.cat_id=c.cat_id LEFT JOIN tbl_supplier s ON i.supplier_id=s.supplier_id where i.item_name LIKE '%"+ filterItemName +"%' ";                          
//              if (filterItemName.equals("")) {
//                sqry = sqry;
//              }
//              else{
//            sqry+=" where i.item_name LIKE '%" + filterItemName + "%'";
//            }
              ResultSet rs = s.executeQuery(sqry);
              
              while(rs.next()){            
                item = new ItemOF();
                item.setItem_id(rs.getInt("i.item_id"));
                item.setItem_name(rs.getString("i.item_name"));
                item.setItem_rate(rs.getInt("i.item_rate"));
                item.setItem_quantity(rs.getInt("i.item_quantity"));
                item.setItem_order_date(rs.getString("i.item_order_date"));
                item.setItem_supplied_date(rs.getString("i.item_supplied_date"));
                item.setItem_detail(rs.getString("i.item_detail"));
                item.setCat_name(rs.getString("c.cat_name"));
                item.setSupplier_name(rs.getString("s.supplier_name"));
                items.add(item);
              }
              this.disconnect();
            }catch(Exception ex){
              throw ex;
            }
            return items;

    }
    
}
