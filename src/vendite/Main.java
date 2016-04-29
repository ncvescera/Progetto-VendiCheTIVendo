package vendite;

public class Main {
    public static void main(String[] args) throws Exception {
        ReadFile testoCSV = new ReadFile("testo.csv");
        //String[] letto;
        Cellulare[] cells = new Cellulare[3];
        
        for(int i=0;i<testoCSV.EOF;i++){
            cells[i] = new Cellulare(CSV.parse(testoCSV.read(), ";"));
             
            /*for(String elem:letto){
                System.out.println(elem);  
            }
            
            System.out.println("\n");
            */
        }
        
        for(Cellulare cell:cells){
            cell.print();
        }
    }

}
