package edu;

/**
 * EX_1_1
 */
public class EX_1_1 {

    public static int sum(){
        int sum =0;
        for(int i=0;i < 101;i+=2){
            sum+=i;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(EX_1_1.sum());   
    }
}