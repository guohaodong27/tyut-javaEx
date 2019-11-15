package edu;

/**
 * @author GuoHaodong
 * EX_2_3
 * calc the number of words
 */
public class EX_2_3 {
    private String sentence;
    public int calc(){
        String[] a = sentence.split(" ");
        return a.length;
    }

    public EX_2_3(String sentence){
        this.sentence = sentence;
    }

    
}
class Test{
    public static void main(String[] args) {
        String s = "hello world my name is China";
        EX_2_3 ex_2_3 = new EX_2_3(s);
        System.out.println(ex_2_3.calc());
    }
}