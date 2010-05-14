package edu.drexel.info637.imudb.domain;

import java.util.Date;

public class User {
    public int    UserID       = 0;
    public String sUserName    = "";
    public String sPass        = "";
    public String sEmail       = "";
    public String sAccessLevel = "";

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
