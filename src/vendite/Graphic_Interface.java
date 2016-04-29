/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendite;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author eliasforna
 */
public class Graphic_Interface extends JFrame implements ActionListener {
    
    
    //Frames
    JFrame f1 = new JFrame();
    
    //Panel
    JPanel brands_Panel = new JPanel();
    JPanel buy_Panel = new JPanel();
    JPanel sub_buy_Panel = new JPanel();
    JPanel prodotto1 = new JPanel();
    JPanel prodotto2 = new JPanel();
    JPanel prodotto3 = new JPanel();
    
    //Button
    JButton b1 = new JButton("SAMSUNG");
    JButton b2 = new JButton("Apple");
    JButton b3 = new JButton("Huwawei");
    JButton b4 = new JButton("Nokia");
    JButton b5 = new JButton("Sony");
    JButton b6 = new JButton("HTC");
    JButton porcodio = new JButton("Tchutchi"){
        {
            setSize(20,100);
            setMaximumSize(getSize());
        }
            };
        
    
    //TextArea
    JTextArea tx = new JTextArea("BUY_PANEL");
    
    
    //TitledBorder
    TitledBorder border_buy_Panel = new TitledBorder("COMPRA UN TELEFONO! ZOCCOLA!");
    
    
    
    
    
    //Inizializzazione Elementi Grafici
    
    public Graphic_Interface()      
    {
        //Specifiche Pannelli Prodotti
        prodotto1.setBackground(Color.red);
        prodotto2.setBackground(Color.blue);
        prodotto3.setBackground(Color.yellow);
        porcodio.setSize(40, 100);
        porcodio.setMaximumSize(porcodio.getSize());
        prodotto1.add(porcodio);
        
        
        
        //Specifiche SUB_BUY_PANEL
        sub_buy_Panel.setLayout(new BoxLayout(sub_buy_Panel, BoxLayout.PAGE_AXIS));
        sub_buy_Panel.add(prodotto1);
        sub_buy_Panel.add(prodotto2);
        sub_buy_Panel.add(prodotto3);
        
        
        
        //Specifiche BUY_PANEL
        buy_Panel.add(sub_buy_Panel);
        buy_Panel.setPreferredSize(new Dimension(200, 200));
        buy_Panel.setBorder(border_buy_Panel);
     
        
        
        //Specifiche BRAND_SPANEL
        brands_Panel.setLayout(new GridLayout(1, 5));
        brands_Panel.add(b1);
        brands_Panel.add(b1);
        brands_Panel.add(b3);
        brands_Panel.add(b4);
        brands_Panel.add(b5);
        brands_Panel.add(b6);
        
        //Modifiche Font BRANDS_PANEL
        b1.setFont(new Font("American Typewriter", Font.BOLD, 20));
        b2.setFont(new Font("American Typewriter", Font.BOLD, 20));
        b3.setFont(new Font("American Typewriter", Font.BOLD, 20));
        b4.setFont(new Font("American Typewriter", Font.BOLD, 20));
        b5.setFont(new Font("American Typewriter", Font.BOLD, 20));
        b6.setFont(new Font("American Typewriter", Font.BOLD, 20));
        
        b1.setForeground(Color.red);
        b2.setForeground(Color.orange);
        b3.setForeground(Color.BLUE);
        b4.setForeground(Color.CYAN);
        b5.setForeground(Color.yellow);
        b6.setForeground(Color.GREEN);
        
        //Specifiche FRAME_1
        f1.add(brands_Panel, "North");
        f1.add(buy_Panel, "Center");
        String titolo_Frame_1 = "VendiCheTiVendo";
        f1.setVisible(true);
        f1.setTitle(titolo_Frame_1);
        f1.setSize(600, 500);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
