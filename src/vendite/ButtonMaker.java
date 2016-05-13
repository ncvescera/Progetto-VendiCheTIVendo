package vendite;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;

//classe per creare bottoni da file
public final class ButtonMaker {
    
    private static String[] NAMES;
    
    public static JButton[] make() {
        File f = new File("brands");
        ArrayList<String> names = new ArrayList<>(Arrays.asList(f.list())); 
        
        String[] button_name = new String[names.size()];
        names.toArray(button_name);
        
        NAMES = button_name;
        
        ArrayList<JButton> btnTemp = new ArrayList();
        
        for (int i = 0; i < button_name.length; i++) {
           btnTemp.add(new JButton(button_name[i]));
        }
        
        JButton[] da_ritornare = new JButton[btnTemp.size()];
        btnTemp.toArray(da_ritornare);
        
        return da_ritornare;
    }
    
    public static String[] getNames(){
        return NAMES;
    }
    
    
}
    
    
    


