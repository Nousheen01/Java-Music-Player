import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album a1 = new Album("Album1", "Taylor Swift");
        a1.addSong("blank_space", 0.30, "songs/blank_space.mp3");
        a1.addSong("cruel_summer", 0.23, "songs/cruel_summer.mp3");
        a1.addSong("out_of_the_woods", 0.28, "songs/out_of_the_woods.mp3");

        Album a2 = new Album("Album2", "Olivia Rodrigo");
        a2.addSong("good_4_u", 0.13, "songs/good_4_u.mp3");
        a2.addSong("deja_vu", 0.29, "songs/deja_vu.mp3");
        a2.addSong("traitor", 0.16, "songs/traitor.mp3");

        Playlist playlist = new Playlist();
        playlist.addSong(a1.findSong("blank_space"));
        playlist.addSong(a1.findSong("cruel_summer"));
        playlist.addSong(a1.findSong("out_of_the_woods"));
        playlist.addSong(a2.findSong("good_4_u"));
        playlist.addSong(a2.findSong("deja_vu"));
        playlist.addSong(a2.findSong("traitor"));

        MusicPlayer player = new MusicPlayer(playlist);

        Scanner sc = new Scanner(System.in);
        System.out.println("🎵 Welcome to My Music Player 🎵");
        System.out.println("Commands: play, next, prev, stop, exit");

        while (true) {
            System.out.print("> ");
            String cmd = sc.nextLine().trim().toLowerCase();

            switch (cmd) {
                case "play":
                    player.play();
                    break;
                case "next":
                    player.next();
                    break;
                case "prev":
                    player.previous();
                    break;
                case "stop":
                    player.stop();
                    break;
                case "exit":
                    player.stop();
                    System.out.println("👋 Exiting Music Player...");
                    return;
                default:
                    System.out.println("❌ Unknown command. Try: play, next, prev, stop, exit");
            }
        }
    }
}
