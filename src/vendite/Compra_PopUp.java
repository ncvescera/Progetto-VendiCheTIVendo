package vendite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Compra_PopUp extends JDialog implements ActionListener{
    //JFrame frame;
    JPanel panel_btn = new JPanel();
    JLabel messaggio = new JLabel("<html>Stai per acquistare: <br><br><table><tr><td>Marca</td><td>Modello</td><td>Prezzo</td></tr>");
    JButton annulla = new JButton("Annulla");
    JButton conferma = new JButton("Conferma");
    
    boolean stato;
    
    ArrayList<Cellulare> cellulari;
    
    public Compra_PopUp(JFrame frame, ArrayList<Cellulare> cellulari){
        super(frame, "Compra");
        
        this.cellulari = cellulari;
        int totale = 0;
        
        for(Cellulare elem:cellulari){
            messaggio.setText(messaggio.getText() +"<tr><td>"+elem.getMarca()+"</td><td>"+elem.getModello()+"</td><td>"+elem.getCosto()+"</td></tr>");
            totale += elem.getCosto();
        }
        messaggio.setText(messaggio.getText()+"</table><hr>Totale: "+totale);
        
        //annulla.setActionCommand("annulla");
        annulla.addActionListener(this);
        conferma.addActionListener(this);
        
        panel_btn.add(conferma);
        panel_btn.add(annulla);
        
        //add(panel_btn);
        this.add(messaggio);
        
        this.add(panel_btn,"South");
        
        
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Annulla")){
            stato = false;
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Ordine completato ! :D");
            stato = true;
            this.dispose();
        }
    }
    
    public boolean isEndedSucces(){
        return stato;
    }
}
