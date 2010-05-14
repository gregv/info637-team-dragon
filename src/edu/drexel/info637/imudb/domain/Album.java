package edu.drexel.info637.imudb.domain;

import java.util.Date;

public class Album {
    public int    AlbumID      = 0;
    public String sName        = "";
    public Date   rDate        = null;
    public String sRecordLabel = "";
    public String sProducer    = "";

    public void setAlbumID(int sID) {
        AlbumID = sID;
    }

    public int getAlbumID() {
        return AlbumID;
    }

    public void setAlbumName(String aID) {
        sName = aID;
    }

    public String getArtistID() {
        return sName;
    }

    public void setReleaseDate(Date sN) {
        rDate = sN;
    }

    public Date getSongName() {
        return rDate;
    }

    public void setRecordLabel(String sAuth) {
        sRecordLabel = sAuth;
    }

    public String getRecordLabel() {
        return sRecordLabel;
    }

    public void setProducer(String sB) {
        sProducer = sB;
    }

    public String getProducer() {
        return sProducer;
    }
}
