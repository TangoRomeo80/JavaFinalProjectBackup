package Executor;

import Databse.ItemDB;
import Object.ItemObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for item report class
 */
public class ReportItemEx {
    
  private ItemDB ItemDl;
  private ItemObj item;
  
  public ReportItemEx() {
    item = new ItemObj();
    ItemDl = new ItemDB();
  }

  public ReportItemEx(ItemObj item) {
    this.item = item;
    this.ItemDl = new ItemDB();
  }

  public ItemObj getitem() {
    return item;
  }

  public void setitem(ItemObj item) {
    this.item = item;
  }
  
  public ArrayList<ItemObj> getItemList() throws Exception{
    try{
      return ItemDl.getItemList();
    }catch(Exception ex){
      throw ex;
    }
  }
}
