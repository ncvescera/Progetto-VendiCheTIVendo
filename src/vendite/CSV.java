package vendite;

import java.util.ArrayList;

public class CSV {
    public static String[] parse(String riga, String separatore){
        String temp;
        ArrayList parsed = new ArrayList();
        int posizione;
        
        while(riga.indexOf(separatore) > 0){
            posizione = riga.indexOf(separatore);
            parsed.add(riga.substring(0, posizione));
            riga = riga.substring(posizione+1);
        }
        parsed.add(riga);
        
        String[] end = new String[parsed.size()];
        parsed.toArray(end);
        
        return end;
    }
}