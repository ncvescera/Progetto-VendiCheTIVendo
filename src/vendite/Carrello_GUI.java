package vendite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carrello_GUI implements ActionListener{
    JFrame frame = new JFrame("Carrello");
    
    JPanel central_panel = new JPanel();
    
    ArrayList<Cellulare> cellulari;
    int button_number;
    
    public Carrello_GUI(ArrayList<Cellulare> cellulari){
        this.cellulari = cellulari;
        central_panel.setLayout(new BoxLayout(central_panel,BoxLayout.Y_AXIS));
        
        int i = 0;
        //Items temporanei per essere aggiunti nel pannello principale in base ai cellulari passati
        JButton btn_temp;
        JLabel label_temp;
        JPanel panel_temp;
        //----------------------------------------------------------------------------------------//
        
        for(Cellulare elem:cellulari){
            panel_temp = new JPanel();
            panel_temp.setName(String.valueOf(i));
            //Inizializzazione della label contenente il nome
            label_temp = new JLabel(elem.getMarca()+" "+elem.getModello());
            label_temp.setName("lab"+i);
            panel_temp.add(label_temp);
            //------------------------------------------------//
            
            //Inizializzazione del bottono per eliminare l'elemento
            btn_temp = new JButton("Elimina");
            btn_temp.setName(String.valueOf(i));
            btn_temp.addActionListener(this);
            panel_temp.add(btn_temp);
            //-----------------------------------------------------//
            
            central_panel.add(panel_temp);
            
            //DEBUG
            System.out.println("i: "+i);
            //-----//
            
            i++;
        }
        
        //Nubero di bottoni, per ora inutile
        button_number = i;
        //----------------------------------//
        
        frame.add(central_panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    int rm_bottoni = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        int i,j;
        JButton btn = (JButton)e.getSource();
        int da_eliminare;
        for(i=0;i<button_number;i++){
            if(Integer.parseInt(btn.getName()) == i){
                System.out.println("Nome bottono: "+Integer.parseInt(btn.getName()));
                cellulari.remove(i-rm_bottoni);
                central_panel.remove(i-rm_bottoni);
                System.out.println("RMButton: "+rm_bottoni);
                System.out.println("i-rmbottoni: "+(i-rm_bottoni));
                rm_bottoni++;
                
                /* Possibile soluzione al problema di sopra ( i nomi dei pannelli non corrispondono con la loro effettiva posizione)
                 * Eliminare il pannello selezionato e poi rinominare tutti i pannelli con un i = 0
                 * Dovrebbe essere semplice e veloce e funzionare correttamente.
                 * Risolvendo questo problema si dovrebbe risolvere anche la gestione della lista dei Cellulari
                */
            }
        }
        
        
        // Serve per refreshare il JFrame
        frame.invalidate();
        frame.validate();
        frame.repaint();
        //---------------------------------//
        
        System.out.println("-----AGGIORNATO----");
        for(Cellulare el:cellulari){
            System.out.println(el.getMarca() + el.getModello());
        }
        /*for(i=0;i<this.button_number;i++){
            if(e.get)
        }*/    
    }
}
