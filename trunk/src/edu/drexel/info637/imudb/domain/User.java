package edu.drexel.info637.imudb.domain;
<<<<<<< .mine
public class User{
    private int UserID=0;
    private String sUserName="";
    private String sPass="";
    private String sEmail="";
    private String sAccessLevel="";
    
    public void setUserID(int iD){UserID=iD;}
    public int getUserID(){return UserID;}
    public void setUserName(String sN){sUserName=sN;}
    public String getUserName(){return sUserName;}
    public void setPass(String sP){sPass=sP;}
    public String getPass(){return sPass;}
    public void setEmail(String sE){sEmail=sE;}
    public String getEmail(){return sEmail;}
    public void setAccessLevel(String sA){sAccessLevel=sA;}
    public String getAccessLevel(){return sAccessLevel;}
}=======
public class User {
    private int    id           = 0;
    private String userName     = "";
    private String password     = "";
    private String emailAddress = "";
    private String accessLevel  = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

}
>>>>>>> .r101
