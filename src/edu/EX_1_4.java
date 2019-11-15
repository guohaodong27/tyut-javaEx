package edu;

/**
 * EX_1_4
 */
public class EX_1_4 {

    public static float function(float x){
        if(x<1){
            return x;
        }else{
            if(x >=10){
                return 4*x;
            }else{
                return 3*x-2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(EX_1_4.function(4));
    }
}