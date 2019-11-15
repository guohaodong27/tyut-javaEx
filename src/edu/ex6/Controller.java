package edu.ex6;

import edu.ex6.component.Mine;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class Controller {
    private View view;
    /**
     * 鼠标监听器
     */
    private  MouseAdapter mouseAdapter;

    /**
     * MineDo
     */
    private MineDO mineDO;

    {
            mouseAdapter = new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton ()== MouseEvent.BUTTON3){
                    // 标记
                    mark ((Mine)e.getComponent ());
                    new Frame ( "You Are win!!" );
                }else{
                    //检查
                    check ( (Mine)e.getComponent ());
                }
            }
        };
    }

    /**
     * 启动游戏方法
     * @param minesNu 地雷数量
     * @param total 总共雷区的宽（雷块总数的算数平方根）
     */
    public void launch(int minesNu,int total){
        this.mineDO = new MineDO ();
        mineDO.setMines ( new Mine[total][total] );
        mineDO.setMineNu ( minesNu );
        mineDO.setTotal ( total );
        mineDO.setMarked ( new HashSet<> ( minesNu ) );
        Set<Integer> set = new HashSet<> (  );
        int x = set.size ();
        Random random = new Random ( System.currentTimeMillis () );
        while(set.size ()<minesNu){
            set.add ( Math.abs (random.nextInt ()%(total*total) ));
        }
        mineDO.setMineIndex ( set );

        this.view = new View (this.mouseAdapter,mineDO);
    }

    /**
     * 重新启动游戏
     */
    public void relaunch() {
        this.view = null;
        this.view = new View (mouseAdapter,mineDO);
    }

    /**
     * 标记为雷块
     */
    public void mark(Mine markMine){
        System.out.println ("mark");
        Set<Integer> mark = mineDO.getMarked ();
        mark.add ( markMine.getX ()*mineDO.getTotal ()+markMine.getY () );
        mineDO.setMarked ( mark );
        markMine.setBackground ( Color.GREEN );
    }

    /**
     * 获胜判断
     */
    public boolean isWin(MineDO mineDO){
        return mineDO.getMineIndex ().equals ( mineDO.getMarked () );
    }

    /**
     * 点击方块判断
     */
    public void check(Mine checkMine){
        System.out.println ("check");
        if(checkMine.isMine ()){
            // todo game over
            new Frame ( "You Are lost" ).setVisible ( true );
            checkMine.setBackground ( Color.BLACK );
        }else{
            int x = checkMine.getX ()-1;
            int y = checkMine.getY ()-1;
            for (int i=0;i<3;i++){
                for (int j = 0; j <3 ; j++) {
                    if(i!=2&&j!=2&&!isOutOfIndex ( x+i )&&!isOutOfIndex ( y+j )){
                        try {
                            check ( mineDO.getMines ()[x+i][y+j] );
                        }catch (ArrayIndexOutOfBoundsException e){
                            e.printStackTrace ();
                        }
                    }
                }
            }
        }
    }

    private boolean isOutOfIndex(int x){
        return x < 0 || x >= mineDO.getTotal ();
    }

}

class Test{
    public static void main(String[] args) {
        Controller controller = new Controller ();
        controller.launch ( 25,5 );
    }
}
