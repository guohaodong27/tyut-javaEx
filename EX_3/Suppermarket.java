package EX_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Suppermarket
 */
public class Suppermarket {

    private List<Goods> shelf;

    public List<Goods> getShelf() {
        return this.shelf;
    }

    public void setShelf(List<Goods> list) {
        this.shelf = list;
    }

    public Suppermarket(int capicity) {
        this.shelf = new ArrayList<Goods>(100);
    }

}

class Test {
    public static void main(String[] args) {
        Suppermarket suppermarket = new Suppermarket(100);
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            new Goods(random.nextInt() % 10, "", random.nextFloat(), "", random.nextInt() % 4).add(suppermarket);
        }

        try {
            new Goods(1).sale(suppermarket);
        } catch (NoGoodsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String info = suppermarket.getShelf().get(3).showMe();
        System.out.println(info);

    }
}