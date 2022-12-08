package com.sayo.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 *
 * 1.举例： (o1, o2) -> Integer.compare(o1, o2);
 * 2.格式：
 *       -> : Lambda操作符，或者叫，箭头操作符
 *       ->左边： Lambda形参列表（其实就是接口中的抽象方法的形参列表）
 *       ->右边： Lambda体（其实就是重写的抽象方法的方法体）
 * 3.Lambda表达式的使用： （分为6种情况）
 *        语法格式一：无参，无返回值。
 *        语法格式二：Lambda需要一个参数，但没有返回值
 *        语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型判断”。
 *        语法格式四：Lambda 若是只需要一个参数是，参数的小括号可以省略。
 *        语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值。
 *        语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
 *        总结： ->左边： Lambda形参列表的参数类型可以省略（类型推算）；如果参数列表只有一个参数小括号也可以省略，两个以上不可省略。
 *              ->右边： Lambda体应该使用一对大括号包裹，如果Lambda体只有一条执行语句（可能是return），可以省略这一对大括号{}和return关键字。
 *
 * 4.Lambda表达式的本质: 是接口的实例。接口得是函数式接口（FunctionalInterface）。我们也可以自己定义函数式接口
 *
 * 5.什么是函数式接口： 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在一个接口上加@FunctionalInterface注释，这样可以检验他是否式一个函数式接口。
 *
 * @author author
 * @create 2022 - 12 - 05
 * 오후 4:54
 */
public class LambdaTest1 {
    //语法格式一：无参，无返回值。
    @Test
    public void test1(){
        Runnable r1 = new Runnable(){

            @Override
            public void run() {  //run()没有
                System.out.println("我爱北京");
            }
        };

        r1.run();

        System.out.println("******************Lambda表达式********************");
        Runnable r2 = () -> {
            System.out.println("我爱天津");
        };
        r2.run();
    }



    //语法格式二：Lambda需要一个参数，但没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>(){

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");

        System.out.println("******************Lambda表达式********************");
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };//前面一整个都作为一个对象出现，对象后面都要加分号。
        con1.accept("一个是听的人当真了，一个是说的人当真了");
    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型判断”。
    @Test
    public void test3(){
        Consumer<String> con2 = (String s) -> {
            System.out.println(s);
        };//前面一整个都作为一个对象出现，对象后面都要加分号。
        con2.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("******************Lambda表达式********************");
        Consumer<String> con3 = (s) -> {  //去掉String
            System.out.println(s);
        };//前面一整个都作为一个对象出现，对象后面都要加分号。
        con3.accept("一个是听的人当真了，一个是说的人当真了");
    }

    @Test
    public void test4(){
        ArrayList<String> list = new ArrayList<>();//类型判断
        //int[] arr = new int[]{1, 2, 3}; //类型判断如下
        int[] arr = {1, 2, 3};
    }

    //语法格式四：Lambda 若是只需要一个参数是，参数的小括号可以省略。
    @Test
    public void test5(){
        Consumer<String> con1 = (s) -> {  //去掉String
            System.out.println(s);
        };//前面一整个都作为一个对象出现，对象后面都要加分号。
        con1.accept("一个是听的人当真了，一个是说的人当真了");
        System.out.println("******************Lambda表达式********************");
        Consumer<String> con2 = s -> {  //去掉String
            System.out.println(s);
        };//前面一整个都作为一个对象出现，对象后面都要加分号。
        con2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    //语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值。
    @Test
    public void test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));  //-1,前小后大

        System.out.println("******************Lambda表达式********************");
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12, 6));//1，前大后小

    }

    //语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test7(){
        Comparator<Integer> com2 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12, 6));

        System.out.println("******************Lambda表达式********************");
        Comparator<Integer> com3 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com3.compare(12, 21));
    }

    @Test
    public void test8(){
        System.out.println("******************本来Lambda表达式********************");
        Consumer<String> con1 = s -> {  //去掉String
            System.out.println(s);
        };//前面一整个都作为一个对象出现，对象后面都要加分号。
        con1.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("******************更简洁的Lambda表达式********************");
        Consumer<String> con2 = s -> System.out.println(s);//前面一整个都作为一个对象出现，对象后面都要加分号。
        con2.accept("一个是听的人当真了，一个是说的人当真了");
    }

}
