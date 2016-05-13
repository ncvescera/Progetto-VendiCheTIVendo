package vendite;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;

//classe per creare bottoni da file
public final class ButtonMaker {
    
    //variabile che contiene tutti i nomi dei bottoni//
    private static String[] NAMES;
    //----------------------------------------------//
    
    public static JButton[] make() {
        //Inserisce in una lista il contenuto di una cartella//
        File f = new File("brands");
        ArrayList<String> names = new ArrayList<>(Arrays.asList(f.list())); 
        //---------------------------------------------------//
        
        //Conversione da ArrayList ad array//
        String[] button_name = new String[names.size()];
        names.toArray(button_name);
        //--------------------------------//
        
        //variabile che contiene tutti i nomi dei bottoni//
        NAMES = button_name;
        //-----------------------------------------------//
        
        //Creazione dei bottoni//
        ArrayList<JButton> btnTemp = new ArrayList();
        
        for (int i = 0; i < button_name.length; i++) {
           btnTemp.add(new JButton(button_name[i]));
        }
        //---------------------//
        
        //Conversione da ArrayList ad Array//
        JButton[] da_ritornare = new JButton[btnTemp.size()];
        btnTemp.toArray(da_ritornare);
        //---------------------------------//
        
        return da_ritornare;
    }
    
    //Ritorna i nomi dei bottoni per gestione dell'ActionListener//
    public static String[] getNames(){
        return NAMES;
    }
    //-----------------------------------------------------------//
}
    
    
    


