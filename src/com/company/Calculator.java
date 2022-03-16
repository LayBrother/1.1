package com.company;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    //BinaryOperator<Integer> devide = (x, y) -> x / y; возникающая ошибка - деление на 0.
    //значение "y" в нашем лямбда-выражении вычисляется в main при помощи calc.minus.apply - это переменная b и она равно 0,
    //далее нулевое значение передается в calc.devide.apply(a, b), где оно является делителем.
    //возможное решение приведено ниже,
    //другой из вариантов - проверять значение детителя(y) непосредственно в main
    BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : 0;

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}
