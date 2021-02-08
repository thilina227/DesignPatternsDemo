package designpatternsdemo.iterator;

import java.util.Arrays;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        //Youtube Top 3 - from Youtube SDK lib
        String youtubeTop3[] = YouTubeSdk.getYoutubeTop3();

        //Spotify Top 3 - from Spotify SDK lib
        List<String> spotifyTop3 = SpotifySdk.getSpotifyTop3();

        System.out.println("-----Using our custom iterator");
        YoutubeContainer youtube = new YoutubeContainer(youtubeTop3);
        printSongs(youtube.getIterator());
        SpotifyContainer spotify = new SpotifyContainer(spotifyTop3);
        printSongs(spotify.getIterator());
        
        System.out.println("\n----Using our Java iterator");
        //using Java's iterator
        javaIteratorPrintSongs(Arrays.asList(youtubeTop3).iterator());
        javaIteratorPrintSongs(spotifyTop3.iterator());
        
        
        
    }

    public static void printSongs(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void javaIteratorPrintSongs(java.util.Iterator iterator){
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

interface Iterator {

    public boolean hasNext();

    public Object next();
}

class YoutubeIterator implements Iterator {

    private String youtubeTop3[];
    int index;

    public YoutubeIterator(String[] songs) {
        this.youtubeTop3 = songs;
    }

    @Override
    public boolean hasNext() {
        if (index < youtubeTop3.length) {
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return youtubeTop3[index++];
        }
        return null;
    }
}

interface Container {

    public Iterator getIterator();
}

class YoutubeContainer implements Container {

    private String youtubeTop3[];

    public YoutubeContainer(String youtubeTop3[]) {
        this.youtubeTop3 = youtubeTop3;
    }

    @Override
    public Iterator getIterator() {
        return new YoutubeIterator(youtubeTop3);
    }

}

class SpotifyContainer implements Container {

    private List<String> spotifyTop3;

    public SpotifyContainer(List<String> spotifyTop3) {
        this.spotifyTop3 = spotifyTop3;
    }

    @Override
    public Iterator getIterator() {
        // implementing iterator as an annonymous inner class
        return new Iterator() {
            int index;

            @Override
            public boolean hasNext() {
                if (index < spotifyTop3.size()) {
                    return true;
                }
                return false;
            }

            @Override
            public String next() {
                if (this.hasNext()) {
                    return spotifyTop3.get(index++);
                }
                return null;
            }
        };
    }
}
