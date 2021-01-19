package designpatternsdemo.singleton;

public class CacheManager {

    private static CacheManager instance;
    
    private CacheManager() {
        CacheConnector.connect();
    }
    
    public static CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }
}



class CacheConnector {
    public static void connect() {}
}