package Object;

/**
 *
 * @author Rahat
 * class to define the user information
 */
public class UserObj {
 
    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userType;
    
    public UserObj(){
        this.userId    = 0;
        this.userName     = "";
        this.userPassword = "";
        this.userEmail    = "";
        this.userType     = "";
    }
    
    public UserObj( int userId, String userName, String userPassword, String userEmail, String userType ){
        this.userId       = userId;
        this.userName     = userName; 
        this.userPassword = userPassword;
        this.userEmail    = userEmail;
        this.userType     = userType; 
    }

    public String getuserEmail() {
        return userEmail;
    }

    public void setuserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getuserPassword() {
        return userPassword;
    }

    public void setuserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getuserType() {
        return userType;
    }

    public void setuserType(String userType) {
        this.userType = userType;
    }
         
}
