package com.sayo.java1;
/**
 *使用同步机制将单例模式中的懒汉式改写为线程安全的。
 */

public class BankTest {
}

class Bank{
    private Bank(){  //单例模式构造器必须是私有的private

    }

    private static Bank instance = null;

    /*public static synchronized Bank getInstance(){//getInstance()是在run（）中调的。  直接加synchronized
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }*/

    public static Bank getInstance() {//getInstance()是在run（）中调的。  直接加synchronized
        //方式一：效率稍差
        /*synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
            return instance;
        }*/
        //方式二:效率更高。
        if (instance == null){
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }

            }
        }
        return instance;
    }
}
