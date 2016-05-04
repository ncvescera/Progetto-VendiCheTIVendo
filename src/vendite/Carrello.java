package vendite;

import java.util.ArrayList;

public class Carrello {
    ArrayList<Cellulare> cellulari;
    int elementi;
    
    public Carrello(){
        cellulari = new ArrayList<>();
        elementi = 0;
    }
    
    public void add(Cellulare cell){
        if(cell != null){
            cellulari.add(cell);
            elementi ++;
        }
    }
    
    public Cellulare getCellulare(int posizione){
        return cellulari.get(posizione);
    }
    
    public void print(){
        for(Cellulare elem:cellulari){
            elem.print();
        }
    }
}
