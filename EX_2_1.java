import java.util.Scanner;

/**
 * @@author GuoHaodong
 * EX_2
 */
public class EX_2_1 {
    private int[] array;
    public void sort(){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
               if (array[j] < array[j+1]){
                   int tmp;
                   tmp = array[j];
                   array[j] = array[j+1];
                   array[j+1] = tmp;
               }
            } 
        }
    }
    public void setArray(int[] array){
        this.array = array;
    }

    public static void main(String[] args) {
        EX_2_1 ex_2 = new EX_2_1();
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i=0 ;i<10;i++){
            array[i] = scanner.nextInt();
        }
        ex_2.setArray(array);
        scanner.close();
        ex_2.sort();
        for (int i : array) {
           System.out.print(i+"\t"); 
        }
        System.out.println();
    }
    

}