package edu.drexel.info637.imudb.domain;

public class User {
    private int    UserID       = 0;
    private String sUserName    = "";
    private String sPass        = "";
    private String sEmail       = "";
    private String sAccessLevel = "";

    public void setUserID(int iD) {
        UserID = iD;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserName(String sN) {
        sUserName = sN;
    }

    public String getUserName() {
        return sUserName;
    }

    public void setPass(String sP) {
        sPass = sP;
    }

    public String getPass() {
        return sPass;
    }

    public void setEmail(String sE) {
        sEmail = sE;
    }

    public String getEmail() {
        return sEmail;
    }

    public void setAccessLevel(String sA) {
        sAccessLevel = sA;
    }

    public String getAccessLevel() {
        return sAccessLevel;
    }
}
