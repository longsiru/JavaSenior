package sayo.java;
/*
*多线程的创建方式：
*               方式一：继承于Thread类->第一步:创建一个继承于Thread类的子类。
*                                  ->第二步:重写Thread类的run方法 -->怎么写？将我们要做的事写在run方法里面，也就是说将此线程执行的操作声明在run（）中
*                                  ->第三步:创建Thread类的子类的对象
*                                  ->第四步:通过此对象调用start（）方法
*               方式一例子：遍历100以内的所有偶数。
*/
//1.创建一个继承于Thread类的子类。
class MyThread extends Thread{
    //2.重写Thread类的run方法
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();  //创建对象快捷键：alt+enter，eclipse里面是ctrl+E  !!!!对象要和类名一样一样一样！！！

        //4.通过此对象调用start（）
        t1.start();  //start()的两个作用：1.启动当前线程。 2.调用当前线程的run（）。
        //问题一：我们不能直接通过调用run()的方式启动线程
        //t1.run(); //如果要用run（），输出的结果就不是多线程的。都是main
        //问题二：再启动一个线程来遍历100以内的偶数时报错。因为不可以再让已经start（）的线程去执行。会报IllegalThreadStateException
        //t1.start(); //
        //这时我们需要新建一个其他名字的对象来调用start（）
        MyThread t2 = new MyThread();
        t2.start();  //Thread会自动给编号名字。


        //System.out.println("hello");  //hello不确定在哪出来，在这里因为只有一行出来的比较快所以基本上是在第一个出来。
        //多写点试试，写个奇数，如下的操作仍然实在main线程中执行的
        for (int i = 0; i < 100; i++){
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "***********main**********");
            }
        }



    }
}
