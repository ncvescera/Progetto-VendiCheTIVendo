package vendite;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carrello_GUI {
    JFrame frame = new JFrame("Carrello");
    
    JPanel central_panel = new JPanel();
    
    Cellulare[] cellulari;
    
    public Carrello_GUI(Cellulare[] cellulari){
        this.cellulari = cellulari;
        central_panel.setLayout(new BoxLayout(central_panel,BoxLayout.Y_AXIS));
        
        for(Cellulare elem:cellulari){
            central_panel.add(new JLabel(elem.getMarca()+" "+elem.getModello()));
        }
        
        frame.add(central_panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
