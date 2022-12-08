package sayo.java;
/**
 *测试Thread中常用的方法：
 *      1.start（）：1.启动当前线程。 2.调用当前线程的run（）。
 *      2.run（）：通常需要重写Thread类中的方法。override。将创建的线程需要执行的操作声明再此方法中。
 *      3.currentThread():静态方法，返回执行当前代码执行的线程
 *      4.getName():获取当前线程的名字。
 *      5.setName():设置当前线程的名字。
 *      6.yield(): 释放当前CPU的执行权。
 *      7.join（）:再线程a中调用线程b的join（），此时线程a进入阻塞状态，直到线程b完全执行完以后线程a才结束阻塞状态。
 *      8.stop():强制结束线程。已过时，不推荐使用
 *      9.sleep(long millitime):睡眠，让当前线程阻塞一会。（比如可以应用到倒计时）
 *      10.isAlive():判断当前线程是否还存活
 *
 *
 * 线程的优先级:不是100%就完全优先执行完，而是有高概率被执行。高优先级的线程要抢占低优先级线程cpu的执行权，
 *           但是只是从概率上讲，高优先级的线程高概率的情况下被执行，并不意味着只有当高优先级的线程执行完后低优先级的线程才执行。
 *      1.MAX_PRIORITY:10
 *        MIN_PRIORITY:1
 *        NORM_PRIORITY:5
 *      2.设置当前线程的优先级
 *        getPriority():获取线程的优先级
 *        setPriority():设置当前线程的优先级
 *
 *
 *
 */
class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++){
            if (i % 2 == 0){

                /*try {
                    sleep(10); //在Thread中可以直接调用， 会报异常，用try-catch
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/

                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
//            if(i % 20 == 0){
//                yield(); //方法里面调用其他方法，前面省略this
//            }
        }

    }


}



public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread();
        h1.setName("线程一");
        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();  //这是的名字是Thread-0，我们可以再start之前来设置线程的名字。

        //给主线程命名，因为是main的不是Thread
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority()+ ":" + i);
            }

           /* if (i == 20){
                try {
                    //在主线程里面调用了线程一的join()，从20 开始将只执行线程一，一执行完了之后再等待cpu分配执行主线程。
                    h1.join(); //在这里只写join会报错，因为现在是在main里面main原本没有这个方法，就要用子类h1去调用。仍然报异常就ALT + ENTER,使用try-catch.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }*/
        }

        System.out.println(h1.isAlive());  //flase


    }
}
