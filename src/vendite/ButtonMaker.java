package vendite;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


//classe per creare bottoni da file
public class ButtonMaker {
    
    
    static void make() {
        File f = new File("brands");
        ArrayList<String> names = new ArrayList<>(Arrays.asList(f.list())); 
    
        for(String elem:names) {
            
        }
    }
    
    
    
    

}
