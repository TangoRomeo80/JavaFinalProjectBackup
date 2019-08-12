package Executor;

import Databse.CategoryDB;
import Object.CategoryObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for damage class
 */
public class CategoryEx {
    
  private CategoryDB CategoryDl;
  private CategoryObj category;
  
  public CategoryEx() {
    category = new CategoryObj();
    CategoryDl = new CategoryDB();
  }

  public CategoryEx(CategoryObj category) {
    this.category = category;
    this.CategoryDl = new CategoryDB();
  }

  public CategoryObj getcategory() {
    return category;
  }

  public void setcategory(CategoryObj category) {
    this.category = category;
  }
  
//  public boolean authenticatecategory() throws Exception{
//    try{
//      CategoryDB.setcategory(category);
//      if(CategoryDB.authenticatecategory()){
//        CategoryDB.loadcategory();
//        category = CategoryDB.getcategory();
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
  
  public ArrayList<CategoryObj> getcategoryList() throws Exception{
    try{
      return CategoryDl.getcategoryList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<CategoryObj> searchcategory() throws Exception{
    try{
      CategoryDl.setcategory(category);
      return CategoryDl.searchcategory();
    }catch(Exception ex){
      throw ex;
    }
  } 
}
