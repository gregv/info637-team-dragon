/**
 * 
 */
package edu.drexel.info637.imudb.search;

import java.util.ArrayList;
import java.util.List;

import edu.drexel.info637.imudb.domain.Album;
import edu.drexel.info637.imudb.domain.Band;
import edu.drexel.info637.imudb.domain.Concert;
import edu.drexel.info637.imudb.domain.Musician;
import edu.drexel.info637.imudb.domain.Song;
import edu.drexel.info637.imudb.domain.Track;

/**
 * @author Team Dragon
 * @class INFO 637 Purpose:
 * @version Notes:
 */
public class SearchResults {

    ArrayList<Object> results = null;

    public SearchResults() {
        results = new ArrayList<Object>();
    }

    public void addResult(Object r) {
        results.add(r);
    }

    public void setAlbumList(List<Album> list) {
        for (Album o : list) {
            results.add(o);
        }
    }

    public void setBand(List<Band> list) {
        for (Band o : list) {
            results.add(o);
        }
    }

    public void setConcertList(List<Concert> list) {
        for (Concert o : list) {
            results.add(o);
        }
    }

    public void setMusicianList(List<Musician> list) {
        for (Musician o : list) {
            results.add(o);
        }
    }

    public void setSongList(List<Song> list) {
        for (Song o : list) {
            results.add(o);
        }
    }

    public void setTrackList(List<Track> list) {
        for (Track o : list) {
            results.add(o);
        }
    }

    public List<Album> getAlbums() {
        List<Album> result = new ArrayList<Album>();

        for (Object o : results) {
            if (o instanceof Album) {
                result.add((Album)o);
            }
        }

        return result;
    }

    public List<Band> getBands() {
        List<Band> result = new ArrayList<Band>();

        for (Object o : results) {
            if (o instanceof Band) {
                result.add((Band)o);
            }
        }

        return result;
    }

    public List<Concert> getConcerts() {
        List<Concert> result = new ArrayList<Concert>();

        for (Object o : results) {
            if (o instanceof Concert) {
                result.add((Concert)o);
            }
        }

        return result;
    }

    public List<Musician> getMusicians() {
        List<Musician> result = new ArrayList<Musician>();

        for (Object o : results) {
            if (o instanceof Musician) {
                result.add((Musician)o);
            }
        }

        return result;
    }

    public List<Song> getSongs() {
        List<Song> result = new ArrayList<Song>();

        for (Object o : results) {
            if (o instanceof Song) {
                result.add((Song)o);
            }
        }

        return result;
    }

    public List<Track> getTracks() {
        List<Track> result = new ArrayList<Track>();

        for (Object o : results) {
            if (o instanceof Track) {
                result.add((Track)o);
            }
        }

        return result;
    }

}
