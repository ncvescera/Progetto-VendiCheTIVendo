package vendite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Carrello_GUI implements ActionListener{
    JFrame frame = new JFrame("Carrello");
    
    JPanel central_panel = new JPanel();
    JLabel titolo = new JLabel("CARRELLO");
    JButton compra = new JButton("Compra");
    
    ArrayList<Cellulare> cellulari;
    int panel_number;
    
    public Carrello_GUI(ArrayList<Cellulare> cellulari){
        this.cellulari = cellulari;
        
        compra.addActionListener(this);
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
        
        //Nubero di pannelli contenuti in central_panel
        panel_number = i;
        //--------------------------------------------//
        frame.add(titolo,"North");
        frame.add(central_panel);
        frame.add(compra,"South");
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int i;
        
        if(e.getActionCommand().equals("Compra")){
            if(cellulari.isEmpty())
                JOptionPane.showMessageDialog(frame,"Il carrello è vuoto non puoi comprare niente ! :(");
            else{
                int conferma_popup = 0;
                String messaggio = "<html>Stai per acquistare: <br><br><table><tr><td>Marca</td><td>Modello</td><td>Prezzo</td></tr>";
                int totale = 0;
                
                for(Cellulare elem:cellulari){
                    //Costruice il testo da mettere dentro al popup e calcola il costo
                    messaggio = messaggio +"<tr><td>"+elem.getMarca()+"</td><td>"+elem.getModello()+"</td><td>"+elem.getCosto()+"</td></tr>";
                    totale += elem.getCosto();
                    //----------------------------------------------------------------//
                }
                messaggio = messaggio+"</table><hr>Totale: "+totale;
                
                conferma_popup = JOptionPane.showConfirmDialog(frame,messaggio,"Compra", conferma_popup);
                
                if(conferma_popup == 0){
                    //Mostra un messaggio di successo ed elimina la lista e il contenuto del carrello
                    JOptionPane.showMessageDialog(frame,"Ordine completato ! :D");
                    cellulari.removeAll(cellulari);
                    while(panel_number!=0){
                        central_panel.remove(0);
                        panel_number--;
                    }
                    //----------------------------------------------------------------------------//
                    
                    // Serve per refreshare il JFrame
                    SwingUtilities.updateComponentTreeUI(frame);
                    //---------------------------------//

                } 
            }
                
        }
        else{
            JButton btn = (JButton)e.getSource();
            JPanel btn_parent = (JPanel)btn.getParent();

            for(i=0;i<panel_number;i++){
                if(Integer.parseInt(btn_parent.getName()) == i){
                    // rimuove della lista e dal pannello central_panel il cellulare che ha scaturito l'evento
                    cellulari.remove(i);
                    central_panel.remove(i);
                    panel_number --;
                    break;
                    //-----------------------------------------------------------------------------------------//
                }
            }

            // Serve per refreshare il JFrame
            SwingUtilities.updateComponentTreeUI(frame);
            //---------------------------------//

            //rinomina tutti i pannelli dentro a central_panel dato che la loro posizione è cambiata
            rinominaPannelli();
            //----------------------------------------------------------------------------------------//

            /* Stampa della lista per DEBUG
            System.out.println("-----AGGIORNATO----");
            for(Cellulare el:cellulari){
                System.out.println(el.getMarca() + el.getModello());
            }
            */
        }
    }
    
    private void rinominaPannelli(){
        int i;
        for(i=0;i<panel_number;i++){
            JPanel PNL_da_rinominare = (JPanel)central_panel.getComponent(i);
            PNL_da_rinominare.setName(String.valueOf(i));
        }
    }
}
