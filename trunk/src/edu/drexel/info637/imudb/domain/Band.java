package edu.drexel.info637.imudb.domain;

import java.util.Date;

public class Band {
    public int    BandID            = 0;
    public String sName             = "";
    public String sPlaceOfFormation = "";
    public Date   YearOfFormation   = null;
    public String sExternalWebsite  = "";
    public String sDescription      = "";
    public String sInfluences       = "";
    public String sHobbies          = "";
    public int    iGenreID          = 0;

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
}
