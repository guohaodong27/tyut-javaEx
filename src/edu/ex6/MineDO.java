package edu.ex6;

import edu.ex6.component.Mine;

import java.time.LocalTime;
import java.util.Set;

public class MineDO {
    /**
     * 计时器
     */
    private LocalTime startTime;

    /**
     * 做标记的块
     */
    private Set<Integer> marked;


    /**
     * 雷块
     */
    private Set<Integer> mineIndex;

    /**
     * 雷块数组
     */
    private Mine[][] mines;

    /**
     * 雷块数量
     */
    private int mineNu;

    /**
     * 总共大小
     */
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMineNu() {
        return mineNu;
    }

    /**
     * 设置雷块的数量
     * @param mineNu 雷块的数量
     * @return MinePanel
     */
    public void setMineNu(int mineNu) {
        this.mineNu = mineNu;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Set<Integer> getMarked() {
        return marked;
    }

    public void setMarked(Set<Integer> marked) {
        this.marked = marked;
    }

    public Set<Integer> getMineIndex() {
        return mineIndex;
    }

    public void setMineIndex(Set<Integer> mineIndex) {
        this.mineIndex = mineIndex;
    }

    public Mine[][] getMines() {
        return mines;
    }

    public void setMines(Mine[][] mines) {
        this.mines = mines;
    }
}
