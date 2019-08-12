package Databse;

import Object.CategoryObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to handle category based interaction with db
 */
public class CategoryDB extends GlobalConnection {
    
    private CategoryObj category;
    private ArrayList<CategoryObj> categorys;
    
    public CategoryDB() {
        super();
        category = new CategoryObj();
        categorys = new ArrayList<CategoryObj>();
    }
    
    public CategoryObj getcategory() {
        return category;
    }

    public void setcategory(CategoryObj category) {
        this.category = category;
    }
    
    // Function to insert the category in category table 
    public boolean insertcategory() throws Exception{
      try{
          return this.insert("INSERT INTO tbl_category ( catName,catDetail ) VALUES ('"+category.getCatName()+"','"+category.getCatDetail()+"')");
        }catch(Exception ex){
          throw ex;
        }
    }
  
    // Function to update the category in category table
    public boolean updatecategory() throws Exception{
      try{
          return this.update("UPDATE tbl_category SET catName='"+category.getCatName()+"', catDetail='"+category.getCatDetail()+"'  WHERE catId = " + category.getCatId());
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to delete the category in category table
    public boolean deletecategory() throws Exception{
        try{
          return this.delete("DELETE FROM tbl_category WHERE catId = " + category.getCatId()); 
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to load the category detail
    public void loadcategory() throws Exception{
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_category WHERE catId = "+category.getCatId());
          while(rs.next()){
            category = new CategoryObj(rs.getInt("catId"), rs.getString("catName"), rs.getString("catDetail"));
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
    }
    
    // Function to list the categorys
    public ArrayList<CategoryObj> getcategoryList() throws Exception{
    categorys = new ArrayList<CategoryObj>();
        try{
          this.connect();
          Statement s = this.conn.createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM tbl_category ORDER BY catId ");
          while(rs.next()){        
            category = new CategoryObj(rs.getInt("catId"), rs.getString("catName"), rs.getString("catDetail"));
            categorys.add(category);
          }
          this.disconnect();
        }catch(Exception ex){
          throw ex;
        }
        return categorys;
    }
    
    // Function to search the categorys
    public ArrayList<CategoryObj> searchcategory() throws Exception{
        String filterCategoryName = category.getCatName();
        int filterCategoryId = category.getCatId();
        String sqry = "";
        categorys = new ArrayList<CategoryObj>();
            try{
              this.connect();
              Statement s = this.conn.createStatement();
              if(!"".equals(filterCategoryName)){
                sqry = "catName LIKE '%" + filterCategoryName +"%' ";
              }
              if(filterCategoryId > 0){
                if("".equals(sqry))
                  sqry = "catId = '"+ filterCategoryId+"' ";
                else
                  sqry = sqry + " AND catId = '"+ filterCategoryId+"' ";
              }
              if(!"".equals(sqry)) sqry = "WHERE "+sqry;
              ResultSet rs = s.executeQuery("SELECT * FROM tbl_category "+sqry+" ORDER BY catName ");
              while(rs.next()){            
                category = new CategoryObj(rs.getInt("catId"), rs.getString("catName"), rs.getString("catDetail"));
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
