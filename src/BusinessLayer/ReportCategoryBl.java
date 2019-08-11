/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.CategoryDl;
import ObjectFactory.CategoryOF;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportCategoryBl {
 
  private CategoryDl CategoryDl;
  private CategoryOF category;
  
  public ReportCategoryBl() {
    category = new CategoryOF();
    CategoryDl = new CategoryDl();
  }

  public ReportCategoryBl(CategoryOF category) {
    this.category = category;
    this.CategoryDl = new CategoryDl();
  }

  public CategoryOF getcategory() {
    return category;
  }

  public void setcategory(CategoryOF category) {
    this.category = category;
  }
  
  public ArrayList<CategoryOF> getcategoryList() throws Exception{
    try{
      return CategoryDl.getcategoryList();
    }catch(Exception ex){
      throw ex;
    }
  }
}
