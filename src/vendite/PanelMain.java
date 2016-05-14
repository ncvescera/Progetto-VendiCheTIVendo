package vendite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelMain extends JPanel implements ActionListener{
    
    private ArrayList<Cellulare> cellulari;
    
    public PanelMain(){
        cellulari = new ArrayList<>();
        //this.setLayout(new BoxLayout());
    }
    
    public void add(ArrayList<Cellulare> aggiunta){
        this.cellulari = aggiunta;
    }
    
    public void make(){
        for(Cellulare cell:cellulari){
            this.add(new JLabel(cell.getModello()));
            this.add(new JLabel(String.valueOf(cell.getCosto())));
            this.add(new JLabel(cell.getDescrizione()));
            this.add(new JButton("Compra"));
        }
        
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public void clear(){
        this.removeAll();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
