/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.CategoryDl;
import ObjectFactory.CategoryOF;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class CategoryBl {
    
  private CategoryDl CategoryDl;
  private CategoryOF category;
  
  public CategoryBl() {
    category = new CategoryOF();
    CategoryDl = new CategoryDl();
  }

  public CategoryBl(CategoryOF category) {
    this.category = category;
    this.CategoryDl = new CategoryDl();
  }

  public CategoryOF getcategory() {
    return category;
  }

  public void setcategory(CategoryOF category) {
    this.category = category;
  }
  
//  public boolean authenticatecategory() throws Exception{
//    try{
//      CategoryDl.setcategory(category);
//      if(CategoryDl.authenticatecategory()){
//        CategoryDl.loadcategory();
//        category = CategoryDl.getcategory();
//        return true;
//      }
//    }catch( Exception ex){
//      throw ex;
//    }
//    return false;
//  }
//  
  public boolean insertcategory() throws Exception{
    try{
      CategoryDl.setcategory(category);
      return CategoryDl.insertcategory();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean updatecategory() throws Exception{
    try{
      CategoryDl.setcategory(category);
      return CategoryDl.updatecategory();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean deletecategory() throws Exception{
    try{
      CategoryDl.setcategory(category);
      return CategoryDl.deletecategory();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<CategoryOF> getcategoryList() throws Exception{
    try{
      return CategoryDl.getcategoryList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<CategoryOF> searchcategory() throws Exception{
    try{
      CategoryDl.setcategory(category);
      return CategoryDl.searchcategory();
    }catch(Exception ex){
      throw ex;
    }
  } 
}
