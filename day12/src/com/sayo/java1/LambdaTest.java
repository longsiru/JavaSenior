package com.sayo.java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda 表达式的使用举例
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable r1 = new Runnable(){

            @Override
            public void run() {
                System.out.println("我爱北京");
            }
        };

        r1.run();

        System.out.println("******************Lambda表达式********************");
        Runnable r2 = () -> System.out.println("我爱天津");
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>(){  //Comparator是一个接口，接口里面只有compare（）这一个方法，所以写不写都无所谓了，可以省略。

            @Override
            public int compare(Integer o1, Integer o2) {  //Comparator<Integer>这里已经定义了<Integer>这个泛型，所以在这里改成lambda会自动知道是什么类型，所以也可以省略。
                return Integer.compare(o1, o2); //return 后面只有一个表达式的话，可以省略。
            }
        };
        int compare1 = com1.compare(12, 21);  //前小后大，输出-1
        System.out.println(compare1);

        System.out.println("******************Lambda表达式********************");
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

        int compare2 = com2.compare(32, 21);  //前大后小，输出1
        System.out.println(compare2);

        System.out.println("******************方法引用********************");
        Comparator<Integer> com3 =  Integer :: compare;

        int compare3 = com3.compare(32, 21);  //前大后小，输出1
        System.out.println(compare3);

    }
}
