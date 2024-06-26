package com.dev.tor.hugo.zerolog.application;

import com.dev.tor.hugo.zerolog.config.CustomLogger;

import java.nio.file.Path;

public abstract class FibonacciCustomLogger {

    private FibonacciCustomLogger(){

    }

    public static void Execute(final long limitValue){
        final var log = new CustomLogger(Path.of("logger_result.txt"));
        long num1 = 0;
        long num2 = 1;
        for (int i = 2; i < limitValue; i++) {
            num2 += num1;
            num1 = num2 - num1;
            log.info("Executing Fibonacci: " + num1);
        }
    }
}
