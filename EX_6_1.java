import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

/**
 * EX_6_1
 */
public class EX_6_1 {

    public static void main(String[] args) {
        MouseListen mouseListen = new MouseListen();
        mouseListen.setVisible(true);
    }
    
}

class MouseListen extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private StatusBar jPanel;

    public MouseListen(){
        this.setTitle("MouseListen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,100,400,200);
        this.jPanel = new StatusBar();
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanel.repaint();
            }
        });
        this.add(this.jPanel);
    }
}

class StatusBar extends  JPanel{
    @Override
    public void paint(Graphics g){
        super.paint(g);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        g.drawString(LocalDateTime.now().format(formatter),0,45);
    }
}
