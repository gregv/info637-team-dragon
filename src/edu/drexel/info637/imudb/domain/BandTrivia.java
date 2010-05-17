package edu.drexel.info637.imudb.domain;

public class BandTrivia{
    private int BandID=0;
    private String BandName="";
    private String sTrivia="";
    
    public void setBandID(int iBID){BandID=iBID;}
    public int getBandID(){return BandID;}
    public void setBandName(String sB){BandName=sB;}
    public String getBandName(){return BandName;}
    public void setTrivia(String sT){sTrivia=sT;}
    public String getTrivia(){return sTrivia;}
}