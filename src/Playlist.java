import java.util.ArrayList;

public class Playlist {
    private ArrayList<Song> songs;
    private int currentIndex;

    public Playlist() {
        songs = new ArrayList<>();
        currentIndex = 0;
    }

    public void addSong(Song song) {
        if (song != null) {
            songs.add(song);
        }
    }

    public Song getCurrentSong() {
        if (songs.size() > 0) {
            return songs.get(currentIndex);
        }
        return null;
    }

    public Song nextSong() {
        if (songs.size() > 0) {
            currentIndex = (currentIndex + 1) % songs.size();
            return songs.get(currentIndex);
        }
        return null;
    }

    public Song previousSong() {
        if (songs.size() > 0) {
            currentIndex = (currentIndex - 1 + songs.size()) % songs.size();
            return songs.get(currentIndex);
        }
        return null;
    }
}
