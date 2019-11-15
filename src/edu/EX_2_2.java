package edu;

/**
 * @author GuoHaodong
 * get the val of the 3x3 matrix
 * 3x3 matrix
 * EX_2_2
 */
public class EX_2_2 {
    /**
     * the matrix
     */
    private int[][] matrix;

    /**
     * the matrix's length
     */
    public int length = 3;

    /**
     * get sum
     * @return the diagonal val's sum
     */
    public int getSum(){
        int sum =0 ;
        for (int i = 0; i < this.length; i++) {
           sum+=matrix[i][i]; 
        }
        return sum;
    } 

    /**
     * constructor use int[][]
     * @param matrix the matrix
     */
    public EX_2_2(int[][] matrix){
        this.matrix = matrix;
    }

    /**
     * constructor no param
     */
    public EX_2_2(){}

    public void setMatrix(int[][] matrix){
        this.matrix = matrix;
    }

    /**
     * test 
     */
    public static void main(String[] args) {
        int[][] array = {{2,3,5},{4,6,8},{4,7,8}};
        EX_2_2 ex_2_2 = new EX_2_2(array);
        int result = ex_2_2.getSum();
        System.out.println(result);
    }
}