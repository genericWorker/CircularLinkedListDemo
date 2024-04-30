public  class Song{
    private String name;
    private String artist;
    private int releaseYear;
    private String listensOnSpotify;

    public Song(String name, String artist, int releaseYear, String listensOnSpotify) {
        this.name = name;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.listensOnSpotify = listensOnSpotify;
    }

    @Override
    public String toString() {
        return "Song{" +
                "Name: '" + name + '\'' +
                ", Artist: '" + artist + '\'' +
                ", Release Year: " + releaseYear +
                ", Listens on Spotify: '" + listensOnSpotify + '\'' +
                '}';
    }
}