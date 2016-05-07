package vendite;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) throws Exception {
        JButton[] b;
        
        b = ButtonMaker.make();
        
        
        //Interface
        JFrame jf = new JFrame();
        JPanel p = new JPanel();
        
        for(int i = 0; i < b.length; i++)
            p.add(b[i]);
        jf.add(p);
        jf.setVisible(true);
        jf.setSize(500,500);
        
    }

}
