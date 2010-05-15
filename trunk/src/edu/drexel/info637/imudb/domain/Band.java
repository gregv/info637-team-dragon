package edu.drexel.info637.imudb.domain;

import java.util.Date;

public class Band {
    private int    BandID            = 0;
    private String sName             = "";
    private String sPlaceOfFormation = "";
    private Date   YearOfFormation   = null;
    private String sExternalWebsite  = "";
    private String sDescription      = "";
    private String sInfluences       = "";
    private String sHobbies          = "";
    private int    iGenreID          = 0;

    public void setBandID(int iB) {
        BandID = iB;
    }

    public int getBandID() {
        return BandID;
    }

    public void setName(String sN) {
        sName = sN;
    }

    public String getName() {
        return sName;
    }

    public void setPlaceFormed(String sP) {
        sPlaceOfFormation = sP;
    }

    public String getPlaceFormed() {
        return sPlaceOfFormation;
    }

    public void setYearFormed(Date sY) {
        YearOfFormation = sY;
    }

    public Date getYearFormed() {
        return YearOfFormation;
    }

    public void setExternalWebsite(String sE) {
        sExternalWebsite = sE;
    }

    public String getExternalWebsite() {
        return sExternalWebsite;
    }

    public void setDescription(String sD) {
        sDescription = sD;
    }

    public String getDescription() {
        return sDescription;
    }

    public void setInfluences(String sI) {
        sInfluences = sI;
    }

    public String getInfluences() {
        return sInfluences;
    }

    public void setHobbies(String hB) {
        sHobbies = hB;
    }

    public String getHobbies() {
        return sHobbies;
    }

    public void setGenreID(int iG) {
        iGenreID = iG;
    }

    public int getGenreID() {
        return iGenreID;
    }

    public String toString() {
        String result = "";

        result += "Band ID: " + BandID + ", ";
        result += "Name: " + sName + ", ";
        result += "Place Formed: " + sPlaceOfFormation;

        return result;
    }
}
