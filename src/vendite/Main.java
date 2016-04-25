package vendite;

public class Main {
    public static void main(String[] args) throws Exception {
        ReadFile testoCSV = new ReadFile("testo.csv");
        String[] letto;
        
        for(int i=0;i<testoCSV.EOF;i++){
            letto = CSV.parse(testoCSV.read(), ";");
            for(String elem:letto){
                System.out.println(elem);  
            }
            System.out.println("\n");
        }
    }

}
