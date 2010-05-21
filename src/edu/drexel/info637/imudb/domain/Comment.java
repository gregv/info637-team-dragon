/**
 * @author Team Dragon
 * This class takes user comments - transportation class
 */

package edu.drexel.info637.imudb.domain;

import java.util.Date;

public class Comment{
    private int BandID=0;
    private int UserID=0;
    private String sComment="";
    private Date dAdded=null;
    public int getBandID() {
        return BandID;
    }
    public void setBandID(int bandID) {
        BandID = bandID;
    }
    public Date getDAdded() {
        return dAdded;
    }
    public void setDAdded(Date added) {
        dAdded = added;
    }
    public String getSComment() {
        return sComment;
    }
    public void setSComment(String comment) {
        sComment = comment;
    }
    public int getUserID() {
        return UserID;
    }
    public void setUserID(int userID) {
        UserID = userID;
    }       
}