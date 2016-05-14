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
    private final PanelMain da_riempire;
    
    public ButtonMenuBar(PanelMain da_riempire){ //costruttore che riempirà il pannello vuoti all'evento click su uno dei bottoni creati
   // public ButtonMenuBar(){
        bottoni = ButtonMaker.make();
        nomi_bottoni = ButtonMaker.getNames();
        this.da_riempire = da_riempire;
        
        for(JButton bottone:bottoni){
            bottone.addActionListener(this);
            this.add(bottone);
        }
    }
    
    private String vecchio = "";
    @Override
    public void actionPerformed(ActionEvent e){
        for(String nome:nomi_bottoni){
            if(e.getActionCommand().equals(nome) && !e.getActionCommand().equals(vecchio)){
                ArrayList<Cellulare> cellulari = new ArrayList<>();
                
                try {
                    ReadFile reader = new ReadFile("brands/"+e.getActionCommand());
                    
                    for(int i=0;i<reader.EOF;i++){
                        cellulari.add(new Cellulare(CSV.parse(reader.read(),";")));
                    }
                    
                    for(Cellulare elem:cellulari){
                        elem.print();
                    }
                    
                    da_riempire.add(cellulari);
                    da_riempire.clear();
                    da_riempire.make();
                    
                    //System.out.println(nome);
                } catch (Exception ex) {
                    Logger.getLogger(ButtonMenuBar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                vecchio = e.getActionCommand();
            }
        }
    }

}
