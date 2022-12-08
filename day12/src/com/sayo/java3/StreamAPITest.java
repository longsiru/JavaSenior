package com.sayo.java3;

import com.sayo.java2.Employee;
import com.sayo.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Stream关注的是对数据的运算，与CPU打交道
 * 集合关注的是数据的存储，与内存打交道。
 * <p>
 * 2.Stream 自己不会存储元素。
 * Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 * <p>
 * 3.Stream执行流程：
 * Stream的实例化：一个数据源（集合，数组），获取一个流
 * 一系列的中间操作：一个中间操作链，对数据源的数据进行处理
 * 终止操作：一旦执行终止操作，就执行中间操作链，并产生结果，之后不会再被使用
 * <p>
 * 测试Stream的实例化（创建）四种方式：创建Stream的方式一：通过集合
 *
 * @author author
 * @create 2022 - 12 - 06
 * 오전 7:13
 */

//创建Stream的方式一：通过集合
public class StreamAPITest {
    //创建Stream的方式一：通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        // default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();

    }

    //创建Stream的方式二：通过数组
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        //重载形式，能够处理对应基本类型的数组:
        // public static IntStream stream(int[] array)
        // public static LongStream stream(long[] array)
        // public static DoubleStream stream(double[] array)
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建 Stream方式三:通过Stream的of().可以调用Stream类静态方法 of(), 通过显示值创建一个流。它可以接收任意数量的参数。
    //public static<T> Stream<T> of(T... values) : 返回一个流
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建 Stream方式四:创建无限流
    //可以使用静态方法 Stream.iterate() 和 Stream.generate(), 创建无限流。
    //迭代:public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
    // 生成:public static<T> Stream<T> generate(Supplier<T> s)
    @Test
    public void test4(){
        //迭代:public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out :: println);
        // 生成:public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math :: random).limit(10).forEach(System.out :: println);
    }
}
