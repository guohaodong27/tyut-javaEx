package edu;

/**
 * EX_5
 */
public class EX_5 {


 public static void main(String[] args) {
  Runnable showTime = ()->{
    long a = System.currentTimeMillis();
    System.out.println("the program is running #"+Thread.currentThread().getId());
    long b = System.currentTimeMillis();
    System.out.println("it spend"+(b-a)+"ms");
 };
    new Thread(showTime).start();
    new Thread(showTime).start();
    new Thread(showTime).start();

 }
}