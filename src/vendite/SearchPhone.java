package vendite;

import java.util.ArrayList;

public class SearchPhone {
    
    public static Cellulare[] search(String da_cercare, Cellulare[] array){
        ArrayList temp = new ArrayList(); //Array list temporaneo per contenere i risultati della ricerca. Diventerà un array
        String[] parole_chiavi = makeParoleChiavi(da_cercare);
        
        for(Cellulare elem:array){
            
            //controlla se le parole chiavi sono contenute nei campi di Cellulare
            for(String str:parole_chiavi){
                /*
                 * se la stringa di ricerca è contenuta nel nome o nel modello del cellulare
                 * quest ultimo viene aggiunto a temp
                 */
                if(elem.getMarca().contains(str) || elem.getModello().contains(str)){
                    temp.add(elem);
                }
            }
        }
        
        //se la ricerca ha prodotto risultati ritorna l'array altrimenti null
        if(temp.size() > 0){
            //conversione da ArrayList ad array di temp
            Cellulare[] risultato = new Cellulare[temp.size()];
            temp.toArray(risultato);

            return risultato;
        }
        else if(temp.isEmpty()){
            if(da_cercare.substring(0,da_cercare.length()-1).length() > 3 ){
                Cellulare[] ricerca_avanzata = search(da_cercare.substring(0,da_cercare.length()-1),array);
                if(ricerca_avanzata != null)
                    return ricerca_avanzata;
                else
                    return null;
            }  
            else
                return null;
        }
        else
            return null;
    }
    
    private static String[] makeParoleChiavi(String da_editare){
        ArrayList<String> temp = new ArrayList<>();
        int indexOfSpace = da_editare.indexOf(" ");
        String subDa_editare = da_editare;
        
        /*
         * Trova le parole chiavi della ricerca.
         * Il separatore delle parole è lo spazio
         */
        while(indexOfSpace != -1 && indexOfSpace != 0){
            temp.add(subDa_editare.substring(0,indexOfSpace));
            subDa_editare = subDa_editare.substring(indexOfSpace);
            indexOfSpace = subDa_editare.indexOf(" ");
        }
        if(subDa_editare.length() > 0)
            temp.add(subDa_editare);
        
        String[] parole_chiavi = new String[temp.size()];
        temp.toArray(parole_chiavi);
        
        return parole_chiavi;
    }
}
