package edu.drexel.info637.imudb.domain;

import java.util.Date;

public class Concert{
    private String sConcertName="";
    private String sBandName="";
    private int iBandID=0;
    private int iConcertID=0;
    private Date EventDate=null;
    private String sVenue="";
    private String sTourName="";
    private String sOrganizer="";
    
    public void setConcertName(String sSet){ sConcertName=sSet;}
    public String getConcertName(){return sConcertName;}
    public void setBandName(String sB){ sBandName=sB;}
    public String getBandName(){return sBandName;}
    public void setBandID(int bID){iBandID=bID;}
    public int getBandID(){return iBandID;}
    public void setConcertID(int iCID){iConcertID=iCID;}
    public int getConcertID(){return iConcertID;}
    public void setEventDate(Date eDate){EventDate=eDate;}
    public Date getEventDate(){return EventDate;}
    public void setVenue(String sV){ sVenue=sV;}
    public String getVenue(){ return sVenue;}
    public void setTourName(String sT){ sTourName=sT;}
    public String getTourName(){return sTourName;}
    public void setOrganizer(String sO){sOrganizer=sO;}
    public String getOrganizer(){return sOrganizer;}
}