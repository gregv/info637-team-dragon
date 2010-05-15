package edu.drexel.info637.imudb.domain;

public class Song{
    private int SongID=0;
    private int ArtistID=0;
    private String sSongName="";
    private String sSongAuthor="";
    private String sBand="";
    
    public void setSongID(int sID){SongID=sID;}
    public int getSongID(){return SongID;}
    public void setArtistID(int aID){ArtistID=aID;}
    public int getArtistID(){return ArtistID;}
    public void setSongName(String sN){sSongName=sN;}
    public String getSongName(){return sSongName;}
    public void setSongAuthor(String sAuth){sSongAuthor=sAuth;}
    public String getSongAuthor(){return sSongAuthor;}
    public void setBand(String sB){sBand=sB;}
    public String getBand(){return sBand;}
}