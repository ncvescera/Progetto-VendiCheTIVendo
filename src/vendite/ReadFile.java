package vendite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    FileReader to_read;
    BufferedReader buffer;
    public final int EOF;
    
    public ReadFile(String file_name) throws Exception {
        to_read = new FileReader(file_name);
        buffer = new BufferedReader(to_read);
        
        int i = 0;
        String temp;
        do{
            temp = buffer.readLine();
            i++;
        }
        while(temp != null);
        
        EOF = i-1; 
        
        to_read = new FileReader(file_name);
        buffer = new BufferedReader(to_read);
    }
    
    public String read() {
        try{
            return buffer.readLine();
        }
        catch(IOException e){
            System.err.println(e);
            return null;
        }
    }
    
    /* FUNZION INCOMPLETA !
     * Non dovrebbe servire, ma in caso contrario c'è già una bozza.
    
    public String[] read(int rows){
        int i;
        ArrayList read = new ArrayList();
        try{
            for(i=0;i<rows;i++){
                
            }
        }
        catch(IOException e){
            System.err.println(e);
            return null;
        }
    }*/
}
