package com.dev.tor.hugo.zerolog.infrastructure.api;

import com.dev.tor.hugo.zerolog.application.Fibonacci;
import com.dev.tor.hugo.zerolog.application.FibonacciCustomLogger;
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

    private static final long LIMIT_VALUE = 1000;

    @PostMapping
    public void startApp(){
        final var sw = new StopWatch();
        sw.start("Fibonacci");
        Fibonacci.Execute(LIMIT_VALUE);
        sw.stop();
        sw.start("FibonacciSlf4j");
        FibonacciSlf4j.Execute(LIMIT_VALUE);
        sw.stop();
        sw.start("FibonacciCustomLogger");
        FibonacciCustomLogger.Execute(LIMIT_VALUE);
        sw.stop();

        log.info("Execution: {}", sw.prettyPrint());
        log.info("Execution: {}", sw.shortSummary());
    }
}
