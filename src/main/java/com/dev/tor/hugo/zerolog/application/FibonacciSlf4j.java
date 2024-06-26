package com.dev.tor.hugo.zerolog.application;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class FibonacciSlf4j {

    private FibonacciSlf4j(){

    }

    public static void Execute(final long limitValue){
        long num1 = 0;
        long num2 = 1;
        for (int i = 2; i < limitValue; i++) {
            num2 += num1;
            num1 = num2 - num1;
            log.info("Executing Fibonacci: {}", num1);
        }
    }
}
