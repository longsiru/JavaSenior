package com.sayo.java1;

/**
 * 1.我们也可以自己定义函数式接口,写入@FunctionalInterface，这是只能有一个抽象方法，写第二个会报错。
 * 2.什么是函数式接口： 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。
 * 3.可以通过Lambda表达式来创建改接口的对象。（如果Lambda表达式抛出一个受检异常，那么该异常需要在接口的抽象方法上声明。
 *
 * @author author
 * @create 2022 - 12 - 06
 * 오전 5:39
 */
@FunctionalInterface
public interface MyInterface {
    void method1();
}
