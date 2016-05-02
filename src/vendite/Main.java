package vendite;

public class Main {
    public static void main(String[] args) throws Exception {
        ReadFile testoCSV = new ReadFile("testo.csv");
        Cellulare[] cells = new Cellulare[4];
        
        //Inizializza l'array di Cellulari
        for(int i=0;i<testoCSV.EOF;i++){
            cells[i] = new Cellulare(CSV.parse(testoCSV.read(), ";"));
        }
        
        //Stampa dell'array di Cellulari
        for(Cellulare cell:cells){
            cell.print();
        }
        
        System.out.println("\nRicerca");
        
        //ricerca un cellulare nell'array di Cellulari
        Cellulare[] ricerca = SearchPhone.search("331110",cells);
        
        if(ricerca != null){
            for(Cellulare elem:ricerca){
                elem.print();
                System.out.println();
            }
        }
        else
            System.out.println("Nessun cellulare trovato!");
    }

}
