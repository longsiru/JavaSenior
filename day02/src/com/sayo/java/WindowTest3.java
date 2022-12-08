package com.sayo.java;
/**
 *使用同步方法来解决Runnable接口的线程安全问题
 *
 *
 * 关于同步方法的总结：1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明，他是默认的
 *                 2.非静态的同步监视器是this，静态的同步监视器是当前类本身（类名.class)
 *
 *
 */

class Window3 implements Runnable{
    private int ticket = 100;
    //Object obj = new Object();

    @Override
    public void run() {
        while(true){
            show();
        }
    }

    private synchronized void show(){  //造一个show方法，设置为同步方法。这里面也有同步监视器，是this。
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ":卖票， 票号为： " + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();


    }
}
