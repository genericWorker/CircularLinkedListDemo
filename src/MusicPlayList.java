import java.util.ListIterator;
import java.util.Scanner;

public class MusicPlayList {

    CircularLinkedList<Song> circularPlaylist = new CircularLinkedList<>();
    ListIterator<Song> iterator = circularPlaylist.iterator();

    public void addSongs() {
        circularPlaylist.add( new Song("Blinding Lights", "The Weeknd", 2020, "4,190,592,883"));
        circularPlaylist.add(new Song("Ludens", "Bring Me the Horizon", 2019, "99,497,179"));
        circularPlaylist.add(new Song("Superhero", "Metro Boomin", 2022, "665,831,751"));
        circularPlaylist.add(new Song("Closer", "Nine Inch Nails", 1994, "256,906,602"));
        circularPlaylist.add(new Song("Schism", "Tool", 2001, "146,330,154"));
    }

    public Song showPreviousSong() {
        if (iterator.hasPrevious())
            return iterator.previous();
        return null;
    }

    public Song showNextSong() {
        if (iterator.hasNext())
            return iterator.next();
        return null;
    }

    public void showAllSongs() {
        for (int i = 0; i < circularPlaylist.size(); i++){
            System.out.println("Song at index: " + i + "\n" + circularPlaylist.get(i));
        }
    }

    public void resetIteratorToIndex(int index) {
        int size = circularPlaylist.size();
        int normalizedIndex = index % size;

        iterator = circularPlaylist.iterator();

        for(int i = 0; i < normalizedIndex; i++){
            Song m = iterator.next();
        }
    }

    public void showSingleSong(Scanner in){
        System.out.println("Enter index to show: ");
        int index = Integer.parseInt(in.nextLine());
        System.out.println("Song at index: " + index + " " + circularPlaylist.get(index));
        resetIteratorToIndex(index + 1);
    }
    public void testMusicPlayList() {
        Scanner in = new Scanner(System.in);
        iterator = circularPlaylist.iterator();
        String menuItem = "";
        while (!menuItem.equals("q")){
            System.out.println("Next Song <n>, Song by index <i>, All songs <a>, Quit <q>: ");
            menuItem = in.nextLine();
            switch ((menuItem)){
                case "n":
                    Song sn = showNextSong();
                    System.out.println(sn);
                    break;
                case "p":
                    Song sp = showPreviousSong();
                    System.out.println(sp);
                    break;
                case "i":
                    showSingleSong(in);
                    break;
                case "a":
                    showAllSongs();
                    break;

            }
        }
        System.out.println("******* Have a good day! *******");

    }

    public static void main(String[] args) {
        MusicPlayList mp = new MusicPlayList();
        mp.addSongs();
        mp.testMusicPlayList();
    }

}
