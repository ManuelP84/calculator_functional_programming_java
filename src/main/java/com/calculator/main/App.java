package main.java.com.calculator.main;

import main.java.com.calculator.operations.IOperation;

import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        System.out.println("****************************************************");
        System.out.println("Welcome to the Functional Programming Calculator");
        System.out.println("****************************************************");


        IOperation adition = (num1, num2) -> num1 + num2;
        IOperation substraction = ((num1, num2) -> num1 - num2);
        IOperation multiply = (a, b) -> Stream.iterate(a, n -> adition.operate(0, a))
                .limit(b).reduce(0, (n, m) -> n + m);
        IOperation division = (a, b) -> Stream
                .iterate(a, n -> n >= 0, n -> b == 0 ?  -1 : substraction.operate(n, b))
                .toList()
                .size()-1;

        var aditionResult = adition.operate(5,5);
        System.out.println("Sum: " + aditionResult);

        var substractResult = substraction.operate(10,5);
        System.out.println("Substraction: " + substractResult);

        var multiplication = multiply.operate(1,5);
        System.out.println("Multiplication: "+ multiplication);

        var divisionResult = division.operate(10,2);
        System.out.println("Division: "+ divisionResult);
    }
}
