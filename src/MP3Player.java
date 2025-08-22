import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class MP3Player {
    private Player player;
    private Thread playThread;
    private boolean paused = false;
    private String currentFile;

    public void play(String filePath) {
        stop(); // stop any previous song
        currentFile = filePath;
        playThread = new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream(filePath);
                player = new Player(fis);
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        playThread.start();
    }

    public void stop() {
        try {
            if (player != null) {
                player.close();
            }
            if (playThread != null) {
                playThread.interrupt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
