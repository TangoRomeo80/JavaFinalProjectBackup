package Databse;

import Object.CategoryObj;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * class to handle category report based interactions with db
 */
public class ReportCategoryDB extends GlobalConnection{
    
    private CategoryObj category;
    private ArrayList<CategoryObj> categorys;
    
    public ReportCategoryDB() {
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
}
