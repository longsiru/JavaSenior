package sayo.java;
/**
 * 例子：创建三个窗口买票，总票数为100张（使用继承Thread类的方式）
 *
 *
 */

class Window extends Thread{
    private static int ticket = 100;//三个对象共享static变量，共享100.

    @Override
    public void run() {
        //卖票
        while(true){
            if (ticket > 0){
                //本身在Thread的子类里面可以省略 Thread.currentThread().直接写getName（）。
                System.out.println(getName() + ": 卖票， 票号为" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}


public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();

    }
}
