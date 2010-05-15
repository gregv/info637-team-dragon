package edu.drexel.info637.imudb.domain;

import java.util.Date;

public class Album {
    private int    AlbumID     = 0;
    private String name        = "";
    private Date   releaseDate = null;
    private String recordLabel = "";
    private String producer    = "";

    /**
     * @return the albumID
     */
    public int getAlbumID() {
        return AlbumID;
    }

    /**
     * @param albumID the albumID to set
     */
    public void setAlbumID(int albumID) {
        AlbumID = albumID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the recordLabel
     */
    public String getRecordLabel() {
        return recordLabel;
    }

    /**
     * @param recordLabel the recordLabel to set
     */
    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    /**
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer the producer to set
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String toString() {
        return AlbumID + ", " + name + ", " + recordLabel + ", " + producer;
    }

}
