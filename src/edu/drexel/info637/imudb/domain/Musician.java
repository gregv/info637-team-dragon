package edu.drexel.info637.imudb.domain;
import java.util.Date;

public class Musician{
    private int MusicianID=0;
    private String sName="";
    private String sPlaceOfBirth="";
    private Date DOB=null;
    private Date DOD=null;
    private String sBandAssociations="";
    
    public void setMusicianID(int iM){MusicianID=iM;}
    public int getMusicianID(){return MusicianID;}
    public void setName(String sN){sName=sN;}
    public String getName(){return sName;}
    public void setPlaceOfBirth(String sP){sPlaceOfBirth=sP;}
    public String getPlaceOfBirth(){return sPlaceOfBirth;}
    public void setDOB(Date dB){DOB=dB;}
    public Date getDOB(){return DOB;}
    public void setDOD(Date dD){DOD=dD;}
    public Date getDOD(){return DOD;}
    public void setBandAssociations(String sB){sBandAssociations=sB;}
    public String getBandAssociations(){return sBandAssociations;}
}