package edu.drexel.info637.imudb.domain;

public class Song{
    private int SongID=0;
    private int AlbumID=0;
    private String sSongName="";
    private String sSongAuthor="";
    private String sBand="";
    private String sAlbumName="";
    
    public void setSongID(int sID){SongID=sID;}
    public int getSongID(){return SongID;}
    public void setAlbumID(int aID){AlbumID=aID;}
    public int getAlbumID(){return AlbumID;}
    public void setSongName(String sN){sSongName=sN;}
    public String getSongName(){return sSongName;}
    public void setSongAuthor(String sAuth){sSongAuthor=sAuth;}
    public String getSongAuthor(){return sSongAuthor;}
    public void setBand(String sB){sBand=sB;}
    public String getBand(){return sBand;}
    public void setAlbumName(String sAN){sAlbumName=sAN;}
    public String getAlbumName(){return sAlbumName;}    
}