package vendite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonMenuBar extends JPanel implements ActionListener{
    
    private final JButton[] bottoni;
    private final String[] nomi_bottoni;
    //private JPanel da_riempire;
    
    //public ButtonMenuBar(JPanel da_riempire){ //costruttore che riempirà il pannello vuoti all'evento click su uno dei bottoni creati
    public ButtonMenuBar(){
        bottoni = ButtonMaker.make();
        nomi_bottoni = ButtonMaker.getNames();
        
        for(JButton bottone:bottoni){
            bottone.addActionListener(this);
            this.add(bottone);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        for(String nome:nomi_bottoni){
            if(e.getActionCommand().equals(nome)){
                ArrayList<Cellulare> cellulari = new ArrayList<>();
                
                try {
                    ReadFile reader = new ReadFile("brands/"+e.getActionCommand());
                    
                    for(int i=0;i<reader.EOF;i++){
                        cellulari.add(new Cellulare(CSV.parse(reader.read(),";")));
                    }
                    
                    for(Cellulare elem:cellulari){
                        elem.print();
                    }
                    
                    //System.out.println(nome);
                } catch (Exception ex) {
                    Logger.getLogger(ButtonMenuBar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //for(int i=0;i<reader;i++){
                 
                //}
            }
        }
    }

}
