package com.dev.tor.hugo.zerolog.infrastructure.api;

import com.dev.tor.hugo.zerolog.application.Fibonacci;
import com.dev.tor.hugo.zerolog.application.FibonacciSlf4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/start")
@Slf4j
public class AppController {

    private static final long LIMIT_VALUE = 1_000_000;
    private static final long LIMIT_VALUE_MAX = 100_000_000;

    @PostMapping
    public void startApp(){
        final var sw = new StopWatch();
        sw.start("Fibonacci Limited Loop: 1.000.000");
        Fibonacci.Execute(LIMIT_VALUE);
        sw.stop();
        sw.start("FibonacciSlf4j Limited Loop: 1.000.000");
        FibonacciSlf4j.Execute(LIMIT_VALUE);
        sw.stop();
        sw.start("Fibonacci Limited Loop: 100.000.000");
        Fibonacci.Execute(LIMIT_VALUE_MAX);
        sw.stop();
        sw.start("FibonacciSlf4j Limited Loop: 100.000.000");
        FibonacciSlf4j.Execute(LIMIT_VALUE_MAX);
        sw.stop();

        log.info("Executions: {}", sw.prettyPrint());
        log.info("Executions: {}", sw.shortSummary());
    }
}
