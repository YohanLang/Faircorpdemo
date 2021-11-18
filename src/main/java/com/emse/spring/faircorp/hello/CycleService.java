package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;


public class CycleService {

    private final ConsoleGreetingService consoleGreetingService;

    @Autowired
    public CycleService(ConsoleGreetingService consoleGreetingService) {
        this.consoleGreetingService = consoleGreetingService;
    }
}