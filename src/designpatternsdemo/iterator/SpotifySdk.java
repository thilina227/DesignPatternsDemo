package designpatternsdemo.iterator;

import java.util.ArrayList;
import java.util.List;

public class SpotifySdk {
    public static List<String> getSpotifyTop3 (){
        List<String> youtubeTop3 = new ArrayList<>();
        youtubeTop3.add("Future – Life Is Good ft. Drake.");
        youtubeTop3.add("Tekashi 6ix9ine – GOOBA.");
        youtubeTop3.add("Lil Baby x 42 Dugg – We Paid.");
        return youtubeTop3;
    }
}
