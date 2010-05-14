package edu.drexel.info637.imudb.domain;

public class Song {
    public int    SongID      = 0;
    public int    ArtistID    = 0;
    public String sSongName   = "";
    public String sSongAuthor = "";
    public String sBand       = "";

    public void setSongID(int sID) {
        SongID = sID;
    }

    public int getSongID() {
        return SongID;
    }

    public void setArtistID(int aID) {
        ArtistID = aID;
    }

    public int getArtistID() {
        return ArtistID;
    }

    public void setSongName(String sN) {
        sSongName = sN;
    }

    public String getSongName() {
        return sSongName;
    }

    public void setSongAuthor(String sAuth) {
        sSongAuthor = sAuth;
    }

    public String getSongAuthor() {
        return sSongAuthor;
    }

    public void setBand(String sB) {
        sBand = sB;
    }

    public String getBand() {
        return sBand;
    }
}
