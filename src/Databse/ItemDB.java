package Databse;

import Object.ItemObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to handle item based interaction with db
 */
public class ItemDB extends GlobalConnection{
    
    private ItemObj item;
    private ArrayList<ItemObj> items;
    
    public ItemDB() {
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
    
    // Function to insert the item in item table 
    public boolean insertItem() throws Exception{
      try{
          this.connect();
          // Convert category name to catId
          String iqry1  = ("SELECT catId FROM tbl_category where catName = '"+item.getCatName()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int cate_id = 0;
          while(rs1.next()){
              cate_id = rs1.getInt("catId");
          }
          if(cate_id==0){
              throw new Exception("Select a Valid Category Name");
          }
          
          // Convert supplier name to supplier id
          String iqry2  = ("SELECT supplierId FROM tbl_supplier where supplierName = '"+item.getsupplierName()+"' ");
          Statement s2  = this.conn.createStatement();
          ResultSet rs2 = s2.executeQuery(iqry2);
          int supp_id = 0;
          while(rs2.next()){
              supp_id = rs2.getInt("supplierId");
          }
          if(supp_id==0){
              throw new Exception("Select a Valid Supplier Name");
          }
                    
          return this.insert("INSERT INTO tbl_item( itemName, itemRate, itemQuantity, itemOrderDate, itemSuppliedDate, itemDetail, catId, supplierId ) VALUES ('"+item.getitemName()+"','"+item.getitemRate()+"','"+item.getitemQuantity()+"','"+item.getitemOrderDate()+"','"+item.getitemSuppliedDate()+"','"+item.getitemDetail()+"','"+cate_id+"','"+supp_id+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the item in item table
    public boolean updateItem() throws Exception{
      try{
           this.connect();
          // Convert category name to catId
          String iqry1  = ("SELECT catId FROM tbl_category where catName = '"+item.getCatName()+"' ");
          Statement s1  = this.conn.createStatement();
          ResultSet rs1 = s1.executeQuery(iqry1);
          int cate_id = 0;
          while(rs1.next()){
              cate_id = rs1.getInt("catId");
          }
          if(cate_id==0){
              throw new Exception("Select a Valid Category Name");
          }
          
          // Convert supplier name to supplier id
          String iqry2  = ("SELECT supplierId FROM tbl_supplier where supplierName = '"+item.getsupplierName()+"' ");
          Statement s2  = this.conn.createStatement();
          ResultSet rs2 = s2.executeQuery(iqry2);
          int supp_id = 0;
          while(rs2.next()){
              supp_id = rs2.getInt("supplierId");
          }
          if(supp_id==0){
              throw new Exception("Select a Valid Supplier Name");
          }
          
          return this.update("UPDATE tbl_item SET itemName='"+item.getitemName()+"', itemRate='"+item.getitemRate()+"', itemQuantity='"+item.getitemQuantity()+"',itemOrderDate='"+item.getitemOrderDate()+"',itemSuppliedDate='"+item.getitemSuppliedDate()+"',itemDetail='"+item.getitemDetail()+"',catId='"+cate_id+"',supplierId='"+supp_id+"'  WHERE itemId = " + item.getItemId());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the tem in item table
    public boolean deleteItem() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_item WHERE itemId = " + item.getItemId()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the item detail
    public void loadItem() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();          
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_item WHERE itemId = "+item.getItemId());
          while(rs.next()){
            item = new ItemObj(rs.getInt("itemId"), rs.getString("itemName"), rs.getInt("itemRate"), rs.getInt("itemQuantity"), rs.getString("itemOrderDate"), rs.getString("itemSuppliedDate"), rs.getString("itemDetail"),rs.getInt("category_id"),rs.getInt("supplierId"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
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
    
    // Function to search the items
    public ArrayList<ItemObj> searchItem() throws Exception{
        String filterItemName = item.getitemName();
        //int filterItemId = item.getItemId();
        //String sqry = "";
        items = new ArrayList<ItemObj>();
            try{
              this.connect();
              Statement s = this.conn.createStatement();
              
              String sqry = "SELECT i.itemId,i.itemName,i.itemRate,i.itemQuantity,i.itemOrderDate,i.itemSuppliedDate,i.itemDetail ,c.catName,s.supplierName FROM tbl_item i LEFT JOIN tbl_category c ON i.catId=c.catId LEFT JOIN tbl_supplier s ON i.supplierId=s.supplierId where i.itemName LIKE '%"+ filterItemName +"%' ";                          
//              if (filterItemName.equals("")) {
//                sqry = sqry;
//              }
//              else{
//            sqry+=" where i.itemName LIKE '%" + filterItemName + "%'";
//            }
              ResultSet rs = s.executeQuery(sqry);
              
              while(rs.next()){            
                item = new ItemObj();
                item.setItemId(rs.getInt("i.itemId"));
                item.setitemName(rs.getString("i.itemName"));
                item.setitemRate(rs.getInt("i.itemRate"));
                item.setitemQuantity(rs.getInt("i.itemQuantity"));
                item.setitemOrderDate(rs.getString("i.itemOrderDate"));
                item.setitemSuppliedDate(rs.getString("i.itemSuppliedDate"));
                item.setitemDetail(rs.getString("i.itemDetail"));
                item.setCatName(rs.getString("c.catName"));
                item.setsupplierName(rs.getString("s.supplierName"));
                items.add(item);
              }
              this.disconnect();
            }catch(Exception ex){
              throw ex;
            }
            return items;

    }
    
}
