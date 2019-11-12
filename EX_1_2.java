/**
 * EX_1_2
 */
public class EX_1_2 {

    /**
     * 水仙花数
     * @return
     */
    private static int power(int x){
        return x*x*x;
    }
    public static  void narcissistic(){
        for(int i =0;i < 1000;i++){
            if(i == power(i/100)+power(i%100/10)+power(i%10)){
                System.out.println(i);
            }
        }
    } 

    public static void main(String[] args) {
        EX_1_2.narcissistic();
    }
}