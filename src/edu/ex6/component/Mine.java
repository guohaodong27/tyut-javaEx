package edu.ex6.component;

import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * @author GuoHaodong
 * 地雷按钮
 */
public class Mine extends Button {

    /**
     * 雷块的宽度
     */
    private static int WIDTH=50;

    /**
     * 雷块的高度
     */
    private static int HEIGHT=50;

    /**
     * 是否是雷块
     */
    private boolean isMine;

    /**
     * 当前雷块周围（1个块范围）的雷块数
     */
    private int aroundMinesNu;

    /**
     * 雷块的相对位置（数组中的位置）
     */
    private int x;
    private int y;

    /**
     * 是否被访问
     */
    private boolean isVisited;



    /**
     * 鼠标监听器
     */
    private MouseAdapter listener;

    public Mine(boolean isMine,int x,int y,MouseAdapter listener){
        this.x = x;
        this.y = y;
        this.isMine = isMine;
        this.addMouseListener ( listener );
    }

    {
        this.setBounds (0,0,40,40);
        this.setSize ( 40,40 );
//        this.setLocation (  x*WIDTH,y*HEIGHT);
        this.setVisible ( true );
        this.isVisited = false;
    }

    @Override
    public void paint(Graphics g){
        super.paint ( g );
        if (this.aroundMinesNu != 0&&this.aroundMinesNu!=-1) {
            g.drawString ( String.valueOf ( this.aroundMinesNu ), 25, 25 );
        }
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAroundMinesNu() {
        return aroundMinesNu;
    }

    public void setAroundMinesNu(int aroundMinesNu) {
        this.aroundMinesNu = aroundMinesNu;
    }

    public MouseAdapter getListener() {
        return listener;
    }

    public void setListener(MouseAdapter listener) {
        this.listener = listener;
    }
    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
