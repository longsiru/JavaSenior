package com.sayo.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大核心函数式接口
 *
 * 1.消费型接口：Consumer<T>的抽象方法是 void accept(T t)：没有返回值。
 * 2.供给型接口：Supplier<T>的抽象方法是 T get()：不放放回T
 * 3.函数型接口：Function<T,R>的抽象方法是 R apply(T t):放个T返会R
 * 4.断定型接口：Predicate<T>的抽象方法是 boolean test(T t):放个t返回boolean。
 *
 *
 * @author author
 * @create 2022 - 12 - 06
 * 오전 5:58
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买了矿泉水，价格为： " + aDouble);
            }
        });

        System.out.println("****************************Lambda表达式******************************");
        happyTime(400, money -> System.out.println("学习太累了，去天上人间买了矿泉水，价格为： " + money));
    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);

        System.out.println("****************************Lambda表达式******************************");
        List<String> list1 = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStrs1 = filterString(list,s ->  s.contains("京"));
        System.out.println(filterStrs1);

    }
    //根据给定的规则，过滤集合中的字符串。此规则是由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();

        for(String s : list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
