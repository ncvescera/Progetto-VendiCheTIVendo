package vendite;

import java.util.ArrayList;

public class SearchPhone {
    
    static Cellulare[] search(String da_cercare, Cellulare[] array){
        ArrayList temp = new ArrayList(); //Array list temporaneo per contenere i risultati della ricerca. Diventerà un array
        
        for(Cellulare elem:array){
            /*
             * se la stringa di ricerca è contenuta nel nome o nel modello del cellulare
             * quest ultimo viene aggiunto a temp
            */
            if(elem.getMarca().contains(da_cercare) || elem.getModello().contains(da_cercare)){
                temp.add(elem);
            }
        }
        
        //se la ricerca ha prodotto risultati ritorna l'array altrimenti null
        if(temp.size() > 0){
            //conversione da ArrayList ad array di temp
            Cellulare[] risultato = new Cellulare[temp.size()];
            temp.toArray(risultato);

            return risultato;
        }
        else
            return null;
    }
}
