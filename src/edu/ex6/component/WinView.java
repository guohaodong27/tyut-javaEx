package edu.ex6.component;

import javax.swing.*;
import java.awt.*;

public class WinView extends JFrame {
    private String info;
    {
        this.setBounds(100,100,400,200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public WinView(String info){
        this.setTitle("INFO");
        this.info = info;
        this.repaint();
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        super.repaint();
//        super.paint(g);
        g.drawString(this.info,50,70);

    }
}
