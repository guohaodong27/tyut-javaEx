package edu.ex6.component;


import edu.ex6.MineDO;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.HashSet;
import java.util.Set;

public class MinePanel extends Panel{

    /**
     * 鼠标监听器
     */
    private MouseAdapter listener;
    /**
     * 构造器
     */
    public MinePanel(MouseAdapter listener){
        this.listener = listener;
    };

    /**
     * 初始化
     */
    {
        this.setVisible ( true );
        this.setBounds ( 100,100,200,200 );
    }

    /**
     * 构建地雷面板
     * @return 构建完成的面板
     */
    public MinePanel builder(MineDO mineDO){
        int index = 0;
        for (int i = 0; i < mineDO.getTotal (); i++) {
            for (int j = 0; j < mineDO.getTotal (); j++) {
                try {
                    if (!mineDO.getMineIndex ().contains (index)) {
                        Mine[][] tmp = mineDO.getMines ();
                        tmp[i][j] = new Mine ( false, i, j, listener);
                        mineDO.setMines ( tmp );
                    } else {
                        Mine[][] tmp = mineDO.getMines ();
                        tmp[i][j] = new Mine ( true, i, j, listener);
                        mineDO.setMines ( tmp );
                    }
                }catch (NullPointerException npe) {
                    npe.printStackTrace ();
                }
                index++;
            }
        }
        return this;
    }

    /**
     * 填充
     */
    public MinePanel fill(MineDO mineDO){
        this.setLayout ( new GridLayout ( mineDO.getTotal (),mineDO.getTotal (),0,0 ) );
        for (Mine[] i :mineDO.getMines ()
                 ) {
            for (Mine j:
                    i) {
                            this.add ( j );
            }
        }
        return this;
    }


}

