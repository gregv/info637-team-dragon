package edu.drexel.info637.imudb.domain;
import java.util.Date;

public class Album{
    private int AlbumID=0;
    private String sName="";
    private Date rDate=null;
    private String sRecordLabel="";
    private String sProducer="";
    
    public void setAlbumID(int sID){AlbumID=sID;}
    public int getAlbumID(){return AlbumID;}
    public void setAlbumName(String aID){sName=aID;}
    public String getAlbumName(){return sName;}
    public void setReleaseDate(Date sN){rDate=sN;}
    public Date getReleaseDate(){return rDate;}
    public void setRecordLabel(String sAuth){sRecordLabel=sAuth;}
    public String getRecordLabel(){return sRecordLabel;}
    public void setProducer(String sB){sProducer=sB;}
    public String getProducer(){return sProducer;}
}