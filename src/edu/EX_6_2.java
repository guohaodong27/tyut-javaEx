package edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EX_6_2{
    private Button button;
    private boolean isClicked;
    private JFrame jFrame;

    private void initBtn(){
        this.button = new Button ();
        this.button.setLabel ( "click it" );
        this.button.setSize ( 2,2 );
        this.button.setBounds ( 30,30,25,20 );
        this.button.addMouseListener ( new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                isClicked=!isClicked;
                button.setLabel (!isClicked?"click again":"click it");
            }
        } );
//        this.button.setVisible ( false );
        this.button.setBackground ( Color.CYAN );
    }

    private void initJfm(){
        jFrame = new JFrame ();
        jFrame.setVisible ( true );
        jFrame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        jFrame.setBounds(100,100,400,200);
        jFrame.setBackground ( Color.BLACK );
    }

    public  void init(){

        this.isClicked = true;
        initJfm ();
        initBtn ();
        this.jFrame.add ( new Panel ( ).add ( this.button ) );
    }
    public static void main(String[] args) {
        new EX_6_2 ().init ();
    }
}