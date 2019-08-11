/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import ObjectFactory.CategoryOF;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportCategoryDl extends GlobalConnection{
    
    private CategoryOF category;
    private ArrayList<CategoryOF> categorys;
    
    public ReportCategoryDl() {
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
}
