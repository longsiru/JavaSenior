package com.sayo.java;
/**
 *使用同步方法来处理继承Thread类的方式中的安全问题
 *
 *
 *
 *
 */

class Window4 extends Thread{
    private static int ticket = 100;//三个对象共享static变量，共享100.

    @Override
    public void run() {
        //卖票
        while(true){
           show();  //非静态可以调用静态方法
        }

    }

    private static synchronized void show(){  //这时的同步监视器不是this，而是Window4.class//下一行代码不行所以写成静态的方法来保证唯一。但是此时getName（）报错了，因为它不是静态的，静态方法只能调用静态方法，所以改成用对象调用
        //private synchronized void show(){  //现在的同步监视器不是this，二是t1t2t3了。不能解决问题。
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //本身在Thread的子类里面可以省略 Thread.currentThread().直接写getName（）。
            System.out.println(Thread.currentThread().getName() + ": 卖票， 票号为" + ticket);
            ticket--;
        }
    }
}


public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();

    }
}
