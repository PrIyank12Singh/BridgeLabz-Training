
import java.util.Scanner;

public class MusicPlaylistApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PlaylistControlService service = new PlaylistControlService();

        while (true) {

            System.out.println("\n1. Add Song");
            System.out.println("2. Play Song");
            System.out.println("3. Remove Song");
            System.out.println("4. View Playlist");
            System.out.println("5. View Recently Played");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Artist: ");
                        String artist = sc.nextLine();

                        System.out.print("Enter Duration (sec): ");
                        int duration = sc.nextInt();

                        TrackSong song =
                                new TrackSong(title, artist, duration);

                        service.addSong(song);
                        break;

                    case 2:
                        System.out.print("Enter song title to play: ");
                        String playTitle = sc.nextLine();
                        service.playSong(playTitle);
                        break;

                    case 3:
                        System.out.print("Enter song title to remove: ");
                        String removeTitle = sc.nextLine();
                        service.removeSong(removeTitle);
                        break;

                    case 4:
                        service.viewPlaylist();
                        break;

                    case 5:
                        service.viewRecentlyPlayed();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (SongAlreadyExistsException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
