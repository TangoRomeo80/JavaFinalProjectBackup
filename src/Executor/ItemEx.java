package Executor;

import Databse.ItemDB;
import Object.ItemObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for item class
 */
public class ItemEx {
  private ItemDB ItemDl;
  private ItemObj item;
  
  public ItemEx() {
    item = new ItemObj();
    ItemDl = new ItemDB();
  }

  public ItemEx(ItemObj item) {
    this.item = item;
    this.ItemDl = new ItemDB();
  }

  public ItemObj getitem() {
    return item;
  }

  public void setitem(ItemObj item) {
    this.item = item;
  }
  
  public boolean insertItem() throws Exception{
    try{
      ItemDl.setitem(item);
      return ItemDl.insertItem();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean updateItem() throws Exception{
    try{
      ItemDl.setitem(item);
      return ItemDl.updateItem();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean deleteItem() throws Exception{
    try{
      ItemDl.setitem(item);
      return ItemDl.deleteItem();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<ItemObj> getItemList() throws Exception{
    try{
      return ItemDl.getItemList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<ItemObj> searchItem() throws Exception{
    try{
      ItemDl.setitem(item);
      return ItemDl.searchItem();
    }catch(Exception ex){
      throw ex;
    }
  }
     
}
