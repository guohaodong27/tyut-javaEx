package EX_3;

import java.util.Iterator;
import java.util.List;

/**
 * Goods
 */
public class Goods {
    private int id;
    private String name;
    private float price;
    private String producer;
    private int number;

    public Goods(int id,String name,float price,String producer,int number){
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.number = number;
    }

    public Goods(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public int getNumber(){
        return this.number;
    }

    public void setNumbet(int number){
        this.number = number;
    }
    
    public void add(Suppermarket suppermarket){
        Iterator<Goods> iterator = suppermarket.getShelf().iterator();
        Goods good = null;
        while(iterator.hasNext()){
            good = iterator.next();
            if(good.getId() == this.getId()){
                good.setNumbet(good.getNumber()+this.getNumber());
            }else{
                List<Goods> list = suppermarket.getShelf();
                list.add(this);
                suppermarket.setShelf(list);
            }
        }
    }

    public boolean sale(Suppermarket suppermarket) throws NoGoodsException{
        Iterator<Goods> iterator = suppermarket.getShelf().iterator();
        Goods goods = null;
        while(iterator.hasNext()){
            goods = iterator.next();
            if(goods.getId() == this.getId() && goods.getNumber()>0){
                goods.setNumbet(goods.getNumber()-1);
                return true;
            }else{
                throw new NoGoodsException();
            }
        }
        return false;
    }

    public String showMe(){
        StringBuilder sb = new StringBuilder();
        sb.append("GoodsId:\t").append(this.id);
        sb.append("GoodsName:\t").append(this.name);
        sb.append("GoodsPrice:\t").append(this.price);
        sb.append("GoodsProducer:\t").append(this.producer);
        return sb.toString();
    }


}