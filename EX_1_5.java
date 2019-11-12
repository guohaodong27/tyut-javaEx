/**
 * EX_1_5
 */
public class EX_1_5 {

    private static void drawHelper(int max,int i){
        int spaceNumber = (max/2)-(i/2);
        for (int j=0;j < spaceNumber;j++){
            System.out.print(" ");
        }
        for (int k=0;k < i+1;k++){
            System.out.print("*");
        }
        System.out.println();
    }

    public static void drawStar(){
        int max = 8;
        for(int i =0;i < max;i+=2){
            drawHelper(max,i);
        }
        for(int i = max-2;i > -1;i-=2){
            drawHelper(max,i);
        }
    }

    public static void main(String[] args) {
        EX_1_5.drawStar();
    }
}