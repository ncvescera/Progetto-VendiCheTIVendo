package vendite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
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
            /*for(Cellulare elem:cellulari)
                elem.print();*/
            if(cellulari.isEmpty())
                JOptionPane.showMessageDialog(frame,"Il carrello è vuoto non puoi comprare niente !");
            else{
                //Da creare nuova classe che esdente JDialog per creare il PopUp della conferma dell'ordine
                //Codice già iniziato e da migliorare solo aspetto grafico
                /*RIGE CHE RIMARRANNO SU QUESTA CLASSE*/
                
                //**Compra_PopUP popup = new Compra_PopUP(frame);**//
                //**frame.setVisible(false);**//
                //**frame.dispose();**// ---> distrugge il frame e rilascia la memoria occupata da esso
                
                /*
                JDialog popUp = new JDialog(frame,"Compra");
                
                JLabel messaggio = new JLabel("<html>Stai per acquistare: <br><br>");
                for(Cellulare elem:cellulari){
                    messaggio.setText(messaggio.getText() +"Marca: "+elem.getMarca()+" Modello: "+elem.getModello()+" Prezzo: "+elem.getCosto()+"<hr>");

                }
                popUp.add(messaggio);
                popUp.setVisible(true);
                popUp.pack();
                */
                //JOptionPane.showMessageDialog(frame,messaggio);
                Compra_PopUp popup = new Compra_PopUp(frame, this.cellulari);
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
            for(i=0;i<panel_number;i++){
                JPanel PNL_da_rinominare = (JPanel)central_panel.getComponent(i);
                PNL_da_rinominare.setName(String.valueOf(i));
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
}
