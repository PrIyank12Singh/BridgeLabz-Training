import java.util.*;

public class PlaylistControlService {

    private LinkedList<TrackSong> playlist = new LinkedList<>();
    private Stack<TrackSong> recentlyPlayed = new Stack<>();
    private Set<String> songTitleSet = new HashSet<>();

    // Add Song
    public void addSong(TrackSong song) throws SongAlreadyExistsException {

        if (songTitleSet.contains(song.getTitle().toLowerCase())) {
            throw new SongAlreadyExistsException(
                    "Song already exists in playlist: " + song.getTitle());
        }

        playlist.add(song);
        songTitleSet.add(song.getTitle().toLowerCase());

        System.out.println("Song added successfully.");
    }

    // Play Song
    public void playSong(String title) {

        for (TrackSong song : playlist) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                recentlyPlayed.push(song);
                System.out.println("Now Playing: " + song);
                return;
            }
        }

        System.out.println("Song not found in playlist.");
    }

    // Remove Song
    public void removeSong(String title) {

        Iterator<TrackSong> iterator = playlist.iterator();

        while (iterator.hasNext()) {
            TrackSong song = iterator.next();

            if (song.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                songTitleSet.remove(song.getTitle().toLowerCase());
                System.out.println("Song removed.");
                return;
            }
        }

        System.out.println("Song not found.");
    }

    // View Playlist
    public void viewPlaylist() {

        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        for (TrackSong song : playlist) {
            System.out.println(song);
        }
    }

    // View Recently Played
    public void viewRecentlyPlayed() {

        if (recentlyPlayed.isEmpty()) {
            System.out.println("No recently played songs.");
            return;
        }

        for (TrackSong song : recentlyPlayed) {
            System.out.println(song);
        }
    }
}
