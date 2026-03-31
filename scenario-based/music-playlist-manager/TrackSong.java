public class TrackSong {

    private String title;
    private String artist;
    private int duration; // in seconds

    public TrackSong(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Title: " + title +
               ", Artist: " + artist +
               ", Duration: " + duration + " sec";
    }
}
