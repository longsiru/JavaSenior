package com.sayo.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 *解决线程安全问题的方式三：Lock锁 ---JDK5.0新增
 *
 * 面试题：synchronized 和 Lock的异同？
 *       1.相同：二者都可以解决线程安全问题
 *       2.不同：synchronized机制在执行完相应的同步代码之后，自动的释放同步监视器，
 *              Lock需要手动的启动同步（lock（）），同时结束同步也需要手动的实现（unlock（））
 */


class Window implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock(true);  //不写默认为false

    @Override
    public void run() {
        while(true){
            try {
                //调用锁定方法：lock（）
                lock.lock();


                if (ticket > 0) {
                    try {
                        Thread.sleep(100);  //此时有线程安全问题。用Lock解决
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ": 售票， 票号为" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }


}
