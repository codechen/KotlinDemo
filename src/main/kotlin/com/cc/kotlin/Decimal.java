package com.cc.kotlin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Decimal<T> {
    private List<? extends T> data;
    private List<? super T> data2;
    private List<?> data3 = new ArrayList<String>();

    public static void main(String[] args) {
        // 精确有问题：原因在于我们的计算机是二进制的，浮点数没有办法是用二进制进行精确表示。
        // CPU表示浮点数由两个部分组成：指数和尾数，这样的表示方法一般都会失去一定的精确度，有些浮点数运算也会产生一定的误差。
        System.out.println(0.2 + 0.1);
        System.out.println(0.3 - 0.1);
        System.out.println(0.2 * 0.1);
        System.out.println(0.3 / 0.1);

        System.out.println("\n");
        BigDecimal bigDecimal = new BigDecimal(2);
        BigDecimal bDouble = new BigDecimal(2.3); // 浮点不建议采用这种 构造方法
        BigDecimal bString = new BigDecimal("2.3"); // 通常建议优先使用String构造方法
        System.out.println("bigDecimal=" + bigDecimal);
        System.out.println("bDouble=" + bDouble);
        System.out.println("bString=" + bString);

        // 当double必须用作BigDecimal的源时，请使用Double.toString(double)转成String，然后使用String构造方法，或使用BigDecimal的静态方法valueOf
        BigDecimal bDouble1 = BigDecimal.valueOf(2.3);
        BigDecimal bDouble2 = new BigDecimal(Double.toString(2.3));
        System.out.println();
        System.out.println("bDouble1=" + bDouble1);
        System.out.println("bDouble2=" + bDouble2);


        BigDecimal a = new BigDecimal("4.6");
        BigDecimal b = new BigDecimal("1.5");
        System.out.println("\n");
        System.out.println("a + b =" + a.add(b));
        System.out.println("a - b =" + a.subtract(b));
        System.out.println("a * b =" + a.multiply(b));
//        System.out.println("a / b =" + a.divide(b)); // BigDecimal除法可能出现不能整除的情况，比如 4.5/1.3，这时会报错
        System.out.println("a / b =" + a.divide(b, 2, BigDecimal.ROUND_HALF_UP)); // BigDecimal除法可能出现不能整除的情况，比如 4.5/1.3，这时会报错
    }
}
