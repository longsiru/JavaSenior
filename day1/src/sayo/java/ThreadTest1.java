package sayo.java;
/**
 * 创建多线程的方式二：实现Runnable接口
 *                 1.创建一个实现了Runnable 接口的类
 *                 2.实现类去实现Runnable中的抽象方法： run()
 *                 3.创建实现类的对象
 *                 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 *                 5.通过Thread类的对象调用start（）。
 *
 *  比较创建线程的两种方式的比较：
 *                 1.开发中优先选择实现Runnable接口：
 *                 2.原因：1.实现的方式没有类的单继承的局限性
 *                           2.实现的方式更适合处理多个线程共享数据的情况。
 *                 3.联系：class Thread implements Runnable， Thread也实现了Runnable
 *                 4.相同点，两种方法都需要重写run（），将创建的线程要执行的逻辑写在run（）中。
 *
 *
 */

class MThread implements Runnable{//1.创建一个实现了Runnable 接口的类
    //2.实现类去实现Runnable中的抽象方法： run().(ALT + ENTER)
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++){
            if (i % 2 ==0){
                System.out.println(Thread.currentThread().getName() + ":" + i);  //因为现在不在Thread的子类中说、所以要写全。
            }
        }
    }



}

public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread mThread = new MThread();

        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);//多态
        t1.setName("线程一");

        //5.通过Thread类的对象调用start（）:启动线程，调用当前线程的run（）-->调用了runnable类型的target的run（）。
        t1.start();

        //再启动一个线程，遍历100以内的偶数
        Thread t2 = new Thread(mThread);
        t2.setName("线程二");
        t2.start();

    }
}
