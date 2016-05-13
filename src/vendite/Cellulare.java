package vendite;

import javax.swing.ImageIcon;

public class Cellulare {
    private final String marca;
    private final String modello;
    private final double costo;
    private final String descrizione;
    private final ImageIcon img;
    
    public Cellulare(String[] dati){
        marca = dati[0];
        modello = dati[1];
        costo = Double.parseDouble(dati[2]);
        descrizione = dati[3];
        img = new ImageIcon(dati[4]);
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getModello(){
        return modello;
    }
    
    public double getCosto(){
        return costo;
    }
    
    public String getDescrizione(){
        return descrizione;
    }
    
    public ImageIcon getImg(){
        return img;
        
    }
    
    public void print(){
        System.out.println("Marca: "+marca);
        System.out.println("Modello: "+modello);
        System.out.println("Costo: "+costo);
        System.out.println("Descrizione: "+descrizione);
        System.out.println("Img: "+img.toString());
    }
}