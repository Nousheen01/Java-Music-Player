public class MusicPlayer {
    private Playlist playlist;
    private MP3Player mp3Player;

    public MusicPlayer(Playlist playlist) {
        this.playlist = playlist;
        this.mp3Player = new MP3Player();
    }

    public void play() {
        Song current = playlist.getCurrentSong();
        if (current != null) {
            System.out.println("▶ Now playing: " + current.getTitle());
            mp3Player.play(current.getFilePath());
        }
    }

    public void next() {
        Song next = playlist.nextSong();
        if (next != null) {
            System.out.println("▶ Now playing: " + next.getTitle());
            mp3Player.play(next.getFilePath());
        }
    }

    public void previous() {
        Song prev = playlist.previousSong();
        if (prev != null) {
            System.out.println("▶ Now playing: " + prev.getTitle());
            mp3Player.play(prev.getFilePath());
        }
    }

    public void stop() {
        System.out.println("⏹ Stopped");
        mp3Player.stop();
    }
}
