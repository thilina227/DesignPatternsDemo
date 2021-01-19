package designpatternsdemo.singleton;




public class DatabaseManager {
    
    private static DatabaseManager databaseManager;
    private String name = "MyDB";
    
    private String storageString = "";
    
    private DatabaseManager() {
        
    }
    
    public String getName(){
        return name;
    }
    
    public String getStorageString(){
        return storageString;
    }
    
    public void setStorageString(String stringToStore) {
        this.storageString = stringToStore;
    }
    
    public static DatabaseManager getInstance(){
        if (databaseManager == null){
            databaseManager = new DatabaseManager();
        }
        return databaseManager;
    }
    
}










