package vendite;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;


//classe per creare bottoni da file
public class ButtonMaker {
    
    
    public static String[] make() {
        File f = new File("brands");
        ArrayList<String> names = new ArrayList<>(Arrays.asList(f.list())); 
        
        String[] da_ritornare = new String[names.size()];
        names.toArray(da_ritornare);
        
        ArrayList<JButton> btnTemp = new ArrayList();
        for (int i = 0; i < da_ritornare.length; i++) {
           btnTemp.add(new JButton(da_ritornare[i]));
        }
        
        
        
        return da_ritornare;
    }
    
    
    
    

}
