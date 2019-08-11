/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectFactory;

/**
 *
 * @author chhabi
 */
public class CategoryOF {
    
    private int cat_id;
    private String cat_name;
    private String cat_detail;
    
    public CategoryOF(){
        this.cat_id     = 0;
        this.cat_name   = "";
        this.cat_detail = "";
    }
    
        public CategoryOF( int cat_id, String cat_name, String cat_detail ){
            this.cat_id     = cat_id;
            this.cat_name   = cat_name;
            this.cat_detail = cat_detail;
        }

    public String getCat_detail() {
        return cat_detail;
    }

    public void setCat_detail(String cat_detail) {
        this.cat_detail = cat_detail;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
                
}
