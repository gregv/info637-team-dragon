package edu.drexel.info637.imudb.domain;

public class Genre{
    private int genreID=0;
    private String sGenre="";
    
    public void setGenreID(int gID){genreID=gID;}
    public int getGenreID(){return genreID;}
    public void setGenreName(String sName){sGenre=sName;}
    public String getGenreName(){return sGenre;}
}