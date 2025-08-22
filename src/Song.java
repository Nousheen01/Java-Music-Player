public class Song {
    private String title;
    private double duration;
    private String filePath;

    public Song(String title, double duration, String filePath) {
        this.title = title;
        this.duration = duration;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return title + " (" + duration + " mins)";
    }
}
