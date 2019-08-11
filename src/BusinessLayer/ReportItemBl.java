/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.ItemDl;
import ObjectFactory.ItemOF;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportItemBl {
    
  private ItemDl ItemDl;
  private ItemOF item;
  
  public ReportItemBl() {
    item = new ItemOF();
    ItemDl = new ItemDl();
  }

  public ReportItemBl(ItemOF item) {
    this.item = item;
    this.ItemDl = new ItemDl();
  }

  public ItemOF getitem() {
    return item;
  }

  public void setitem(ItemOF item) {
    this.item = item;
  }
  
  public ArrayList<ItemOF> getItemList() throws Exception{
    try{
      return ItemDl.getItemList();
    }catch(Exception ex){
      throw ex;
    }
  }
}
