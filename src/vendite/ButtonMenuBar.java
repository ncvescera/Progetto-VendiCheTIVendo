package vendite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public void actionPerformed(ActionEvent e) {
        for(String nome:nomi_bottoni){
            if(e.getActionCommand().equals(nome)){
                System.out.println(nome);
            }
        }
    }

}
