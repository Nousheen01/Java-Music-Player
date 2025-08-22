import javazoom.jl.player.Player;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;

public class MusicPlayerGUI extends JFrame {
    private ArrayList<String> playlist;
    private int currentIndex = 0;
    private Player player;
    private Thread playThread;
    private JLabel nowPlaying;

    public MusicPlayerGUI() {
        setTitle("🎵 Java Music Player");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Playlist songs
        playlist = new ArrayList<>();
        playlist.add("songs/blank_space.mp3");
        playlist.add("songs/cruel_summer.mp3");
        playlist.add("songs/out_of_the_woods.mp3");
        playlist.add("songs/good_4_u.mp3");
        playlist.add("songs/deja_vu.mp3");
        playlist.add("songs/traitor.mp3");

        // Now Playing Label
        nowPlaying = new JLabel("Now Playing: None", SwingConstants.CENTER);
        nowPlaying.setFont(new Font("Arial", Font.BOLD, 14));
        add(nowPlaying, BorderLayout.NORTH);

        // Buttons Panel
        JPanel panel = new JPanel();
        JButton playBtn = new JButton("▶ Play");
        JButton nextBtn = new JButton("⏭ Next");
        JButton prevBtn = new JButton("⏮ Previous");
        JButton stopBtn = new JButton("⏹ Stop");

        panel.add(prevBtn);
        panel.add(playBtn);
        panel.add(nextBtn);
        panel.add(stopBtn);
        add(panel, BorderLayout.CENTER);

        // Actions
        playBtn.addActionListener(e -> play());
        nextBtn.addActionListener(e -> nextSong());
        prevBtn.addActionListener(e -> prevSong());
        stopBtn.addActionListener(e -> stop());

        setVisible(true);
    }

    private void play() {
        stop();
        String file = playlist.get(currentIndex);
        nowPlaying.setText("Now Playing: " + file.substring(file.lastIndexOf("/") + 1));
        playThread = new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream(file);
                player = new Player(fis);
                player.play();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        playThread.start();
    }

    private void stop() {
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

    private void nextSong() {
        currentIndex = (currentIndex + 1) % playlist.size();
        play();
    }

    private void prevSong() {
        currentIndex = (currentIndex - 1 + playlist.size()) % playlist.size();
        play();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MusicPlayerGUI::new);
    }
}
