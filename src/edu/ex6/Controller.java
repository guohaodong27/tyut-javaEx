package edu.ex6;

import edu.ex6.component.Mine;
import edu.ex6.component.WinView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

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

                    // 获胜
                    if(isWin(mineDO)){
                        JFrame win = new WinView("You Have Win");
                        win.repaint();
                    }
                }else{
                    //检查
                    Mine m = (Mine)e.getComponent ();
                    if (m.isMine()){
                        JFrame lost = new WinView("You Have Lost");
                        lost.repaint();
                    }
                    levelOrder(m);
                }
            }
        };
    }

    /**
     * 启动游戏方法
     * @param minesNu 地雷数量
     * @param total 总共雷区的宽（雷块总数的算数平方根）
     */
    void launch(int minesNu, int total){
        this.mineDO = new MineDO ();
        mineDO.setMines ( new Mine[total][total] );
        mineDO.setMineNu ( minesNu );
        mineDO.setTotal ( total );
        mineDO.setMarked ( new HashSet<> ( minesNu ) );

        // 生成雷区位置
        Set<Integer> set = new HashSet<> (  );
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
    private void mark(Mine markMine){
        Set<Integer> mark = mineDO.getMarked ();
        Integer index = markMine.getX ()*mineDO.getTotal ()+markMine.getY ();

        // 判断是否已经加入标记
        if (mark.contains(index)) {
            mark.remove(index);
            markMine.setBackground ( Color.GRAY);
        } else {
            mark.add(index);
            markMine.setBackground ( Color.GREEN );
        }
        mineDO.setMarked ( mark );
    }

    /**
     * 获胜判断
     */
    private boolean isWin(MineDO mineDO){
        return mineDO.getMineIndex ().equals ( mineDO.getMarked () );
    }

    /**
     * 遍历雷区
     * @param orderMine 点击的雷区
     */
    private void levelOrder(Mine orderMine){
        // 如果周围8个没有雷则将雷块加入队列
        Queue<Mine> queue = new LinkedList<> (  );

        // 周围的雷块数
        int count =0;
        if(!orderMine.isMine()&&!orderMine.isVisited()){
            int x = orderMine.getX ()-1;
            int y = orderMine.getY ()-1;
            for (int i=0;i<3;i++){
                for (int j = 0; j <3 ; j++) {
                    if(!(i==1&&j==1)&& isOutOfIndex(x + i) && isOutOfIndex(y + j)){
                        try {
                            Mine cur = mineDO.getMines()[x+i][y+j];
                            // 计数
                            if (cur.isMine ()) {
                                count++;
                            }else{
                                if (!cur.isVisited()) {
                                    queue.add(mineDO.getMines()[x+i][y+j]);
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){
                            e.printStackTrace ();
                        }
                    }
                }
            }
            // order the mine around and make it visited
            orderMine.setVisited(true);
            orderMine.setBackground(Color.GRAY);
            if (!(count==0)){
                orderMine.setAroundMinesNu(count);
                orderMine.repaint();
            }else{
                if (queue.size()!=0) {
                    queue.forEach(this::levelOrder);
                }
            }
        }
    }

    // 检验是否超出总的雷区
    private boolean isOutOfIndex(int x){
        return x >= 0 && x < mineDO.getTotal();
    }

}

class Test {
    public static void main(String[] args) {
        Controller controller = new Controller ();
        controller.launch(1,6);

    }
}

