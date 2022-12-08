package com.sayo.java;

/**
 * 例子：创建三个窗口买票，总票数为100张（使用继承Thread类的方式）
 *使用同步代码块解决继承类的方式的线程安全问题
 *
 * 说明：在继承Thread类创建多线程的方式中，要慎用this充当同步监视器，可以考虑使用当前类来充当同步监视器。
 *
 */

class Window2 extends Thread{
    private static int ticket = 100;//三个对象共享static变量，共享100.
    private static Object obj = new Object();//保证唯一；三个对象共享static变量，共享100.因为下面造了多个对象，所以为了保证唯一，就要加static

    @Override
    public void run() {
        //卖票
        while(true){
            //synchronized(obj) {  //synchronized(this) 是错误的，只能新建一个对象，因为这时this代表t1,t2,t3.这时对象不唯一，锁就不唯一。
            synchronized(Window2.class) { //也可以这样写，因为Window2是唯一的，类也是对象。Window2.class只会加载一次，也就意味着只有一次。
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    //本身在Thread的子类里面可以省略 Thread.currentThread().直接写getName（）。
                    System.out.println(getName() + ": 卖票， 票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();

    }
}

