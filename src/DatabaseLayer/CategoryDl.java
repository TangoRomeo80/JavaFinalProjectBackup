/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.CategoryOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class CategoryDl extends GlobalConnection {
    
    private CategoryOF category;
    private ArrayList<CategoryOF> categorys;
    
    public CategoryDl() {
        super();
        category = new CategoryOF();
        categorys = new ArrayList<CategoryOF>();
    }
    
    public CategoryOF getcategory() {
        return category;
    }

    public void setcategory(CategoryOF category) {
        this.category = category;
    }
    
    // Function to insert the category in category table 
    public boolean insertcategory() throws Exception{
      try{
          return this.insert("INSERT INTO tbl_category ( cat_name,cat_detail ) VALUES ('"+category.getCat_name()+"','"+category.getCat_detail()+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the category in category table
    public boolean updatecategory() throws Exception{
      try{
          return this.update("UPDATE tbl_category SET cat_name='"+category.getCat_name()+"', cat_detail='"+category.getCat_detail()+"'  WHERE cat_id = " + category.getCat_id());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the category in category table
    public boolean deletecategory() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_category WHERE cat_id = " + category.getCat_id()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the category detail
    public void loadcategory() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_category WHERE cat_id = "+category.getCat_id());
          while(rs.next()){
            category = new CategoryOF(rs.getInt("cat_id"), rs.getString("cat_name"), rs.getString("cat_detail"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to list the categorys
    public ArrayList<CategoryOF> getcategoryList() throws Exception{
    categorys = new ArrayList<CategoryOF>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_category ORDER BY cat_id ");
          while(rs.next()){        
            category = new CategoryOF(rs.getInt("cat_id"), rs.getString("cat_name"), rs.getString("cat_detail"));
            categorys.add(category);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return categorys;
    }
    
    // Function to search the categorys
    public ArrayList<CategoryOF> searchcategory() throws Exception{
        String filterCategoryName = category.getCat_name();
        int filterCategoryId = category.getCat_id();
        String sqry = "";
        categorys = new ArrayList<CategoryOF>();
            try{
              this.connect();
              Statement s = this.conn.createStatement();
              if(!"".equals(filterCategoryName)){
                sqry = "cat_name LIKE '%" + filterCategoryName +"%' ";
              }
              if(filterCategoryId > 0){
                if("".equals(sqry))
                  sqry = "cat_id = '"+ filterCategoryId+"' ";
                else
                  sqry = sqry + " AND cat_id = '"+ filterCategoryId+"' ";
              }
              if(!"".equals(sqry)) sqry = "WHERE "+sqry;
              ResultSet rs = s.executeQuery("SELECT * FROM tbl_category "+sqry+" ORDER BY cat_name ");
              while(rs.next()){            
                category = new CategoryOF(rs.getInt("cat_id"), rs.getString("cat_name"), rs.getString("cat_detail"));
                categorys.add(category);
              }
              this.disconnect();
            }catch(Exception ex){
              throw ex;
            }
            return categorys;
     }
    
    // Function to authenticate the categorys
//    public boolean authenticatecategory() throws Exception{
//     try{
//      this.connect();
//      Statement s = this.conn.createStatement();
//      ResultSet rs;
//      rs = s.executeQuery("SELECT category_password FROM tbl_category WHERE category_name = '"+ category.getcategory_name()+"' and category_type= '"+category.getcategory_type()+"' ");
//      while(rs.next()){
//        if(rs.getString("category_password").equals(category.getcategory_password()))
//          return true;
//        if(rs.getString("category_type").equals(category.getcategory_type()))
//          return true;
//      }
//      this.disconnect();
//     }catch(Exception ex){
//          throw ex;
//        }
//        return false;
//     }
}
