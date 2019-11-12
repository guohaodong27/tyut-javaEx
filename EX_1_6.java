/**
 * EX_1_6
 */
public class EX_1_6 {

    public static int[] leap(){
        int[] res = new int[100];
        int in = 0;
        for(int i=1900;i < 2100;i++){
            if((i%4==0 &&i%100!=0)){
                res[in++] = i;
            }
            if(i%400==0){
                res[in++] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = EX_1_6.leap();
        int i=0;
        for (int i : a) {
           System.out.print(i);
            if(i%5==0){
                System.out.println();
            }
            i++;
        }
    }
}