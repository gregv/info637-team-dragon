package edu.drexel.info637.imudb.domain;

public class Track {
    public int TrackID     = 0;
    public int SongID      = 0;
    public int AlbumID     = 0;
    public int TrackNumber = 0;
    public int TrackLength = 0;

    public void setSongID(int sID) {
        SongID = sID;
    }

    public int getSongID() {
        return SongID;
    }

    public void setArtistID(int aID) {
        TrackID = aID;
    }

    public int getTrackID() {
        return TrackID;
    }

    public void setAlbumID(int sN) {
        AlbumID = sN;
    }

    public int getAlbumID() {
        return AlbumID;
    }

    public void setSongAuthor(int sAuth) {
        TrackNumber = sAuth;
    }

    public int getTrackNumber() {
        return TrackNumber;
    }

    public void setTrackLength(int sB) {
        TrackLength = sB;
    }

    public int getTrackLength() {
        return TrackLength;
    }
}
