package com.dev.tor.hugo.zerolog.application;

public abstract class Fibonacci {

    private Fibonacci(){

    }

    public static void Execute(final long limitValue){
        long num1 = 0;
        long num2 = 1;
        for (int i = 2; i < limitValue; i++) {
            num2 += num1;
            num1 = num2 - num1;
        }
    }
}
