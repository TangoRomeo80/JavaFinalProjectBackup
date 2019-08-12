package Object;

/**
 *
 * @author Rahat
 * Class to hold the structure of the item categories
 */
public class CategoryObj {
    
    private int catId;
    private String catName;
    private String catDetail;
    
    public CategoryObj(){
        this.catId    = 0;
        this.catName   = "";
        this.catDetail = "";
    }
    
    public CategoryObj( int catId, String catName, String catDetail ){
        this.catId    = catId;
        this.catName   = catName;
        this.catDetail = catDetail;
    }

    public String getCatDetail() {
        return catDetail;
    }

    public void setCatDetail(String catDetail) {
        this.catDetail = catDetail;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId= catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
                
}
