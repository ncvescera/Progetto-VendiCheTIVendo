package vendite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
        int i;
        JButton btn = (JButton)e.getSource();
        JPanel btn_parent = (JPanel)btn.getParent();
        int da_eliminare;
        for(i=0;i<button_number;i++){
            if(Integer.parseInt(btn_parent.getName()) == i){
                // rimuove della lista e dal pannello central_panel il cellulare che ha scaturito l'evento
                cellulari.remove(i);
                central_panel.remove(i);
                button_number --;
                break;
                //-----------------------------------------------------------------------------------------//
            }
        }
         
        // Serve per refreshare il JFrame
        SwingUtilities.updateComponentTreeUI(frame);
        //---------------------------------//
        
        //rinomina tutti i pannelli dentro a central_panel dato che la loro posizione è cambiata
        for(i=0;i<button_number;i++){
            JPanel PNL_da_rinopminare = (JPanel)central_panel.getComponent(i);
            PNL_da_rinopminare.setName(String.valueOf(i));
        }
        //----------------------------------------------------------------------------------------//
        /* Stampa della lista per DEBUG
        System.out.println("-----AGGIORNATO----");
        for(Cellulare el:cellulari){
            System.out.println(el.getMarca() + el.getModello());
        }
        */
    }
}
