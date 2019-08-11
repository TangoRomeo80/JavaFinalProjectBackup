/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.ItemDl;
import ObjectFactory.ItemOF;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class ItemBl {
  private ItemDl ItemDl;
  private ItemOF item;
  
  public ItemBl() {
    item = new ItemOF();
    ItemDl = new ItemDl();
  }

  public ItemBl(ItemOF item) {
    this.item = item;
    this.ItemDl = new ItemDl();
  }

  public ItemOF getitem() {
    return item;
  }

  public void setitem(ItemOF item) {
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
  
  public ArrayList<ItemOF> getItemList() throws Exception{
    try{
      return ItemDl.getItemList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<ItemOF> searchItem() throws Exception{
    try{
      ItemDl.setitem(item);
      return ItemDl.searchItem();
    }catch(Exception ex){
      throw ex;
    }
  }
     
}
