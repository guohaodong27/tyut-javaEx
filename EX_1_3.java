/**
 * EX_1_3
 */
public class EX_1_3 {

    public static int[] getPrimeNumber(int offset,int length){
        int[] prime = new int[(length-offset)/2];
        // int[] prime = new int[100];
        int in = 0;
        if(offset < 3){
            prime[in++] = 2;
        }

        for (int i = offset>2?offset:2;i < length;i++ ){
            for(int j = 2;j < i;j++){
                if(i%j == 0){
                    break;
                }
                if(j==i-1){
                    prime[in++] = i;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        int[] a = EX_1_3.getPrimeNumber(0, 100);
        for (int i : a) {
           System.out.println(i); 
        }
    }
}