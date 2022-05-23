package main.java.com.calculator.main;

import main.java.com.calculator.operations.IOperation;

public class App {
    public static void main(String[] args) {
        System.out.println("****************************************************");
        System.out.println("Welcome to the Functional Programming Calculator");
        System.out.println("****************************************************");

        IOperation sumImplementation = (num1, num2) -> num1 + num2;
        IOperation substractImplementation = ((num1, num2) -> num1 - num2);

        var sumResult = executeSum(sumImplementation);
        System.out.println(sumResult);

        var substractResult = executeSubstraction(substractImplementation);
        System.out.println(substractResult);
    }

    static Integer executeSum(IOperation sum){
        return sum.operate(5,5);
    }

    static Integer executeSubstraction(IOperation substraction){
        return substraction.operate(8,4);
    }
}
