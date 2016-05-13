package vendite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonMenuBar extends JPanel implements ActionListener{
    
    private final JButton[] bottoni;
    private final String[] nomi_bottoni;
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
