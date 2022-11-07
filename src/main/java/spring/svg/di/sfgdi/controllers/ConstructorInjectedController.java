package spring.svg.di.sfgdi.controllers;

import org.springframework.stereotype.Controller;
import spring.svg.di.sfgdi.services.GreetingServiceImpl;

@Controller
public class ConstructorInjectedController {
    private final GreetingServiceImpl greetingService;

    public ConstructorInjectedController(GreetingServiceImpl greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
