/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatternsdemo.singleton;

public class DesignPatternsDemo {

    public static void main(String[] args) {
      
        DatabaseManager dbm1 = DatabaseManager.getInstance();
        
        dbm1.setStorageString("Hello");
        
        
        ///SOME LONG CODE     
        
        
        DatabaseManager dbm2 = DatabaseManager.getInstance();
        
        System.out.println(dbm2.getStorageString());
        
        
        
    }
    
   
}
