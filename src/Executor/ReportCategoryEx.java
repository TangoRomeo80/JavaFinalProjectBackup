package Executor;

import Databse.CategoryDB;
import Object.CategoryObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for category report class
 */
public class ReportCategoryEx {
 
  private CategoryDB CategoryDl;
  private CategoryObj category;
  
  public ReportCategoryEx() {
    category = new CategoryObj();
    CategoryDl = new CategoryDB();
  }

  public ReportCategoryEx(CategoryObj category) {
    this.category = category;
    this.CategoryDl = new CategoryDB();
  }

  public CategoryObj getcategory() {
    return category;
  }

  public void setcategory(CategoryObj category) {
    this.category = category;
  }
  
  public ArrayList<CategoryObj> getcategoryList() throws Exception{
    try{
      return CategoryDl.getcategoryList();
    }catch(Exception ex){
      throw ex;
    }
  }
}
