package edu.ex6;

import edu.ex6.component.MinePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.EventListener;

public class View extends JFrame {
    {
        this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
        this.setVisible ( true );
    }

    public View(MouseAdapter minePanelListener,MineDO mineDO){
        this.setBounds ( 0,0,mineDO.getTotal ()*50,mineDO.getTotal ()*50);
        MinePanel mp = new MinePanel ( minePanelListener )
                .builder (mineDO)
                .fill (mineDO);

        this.add ( mp );
    }
}
