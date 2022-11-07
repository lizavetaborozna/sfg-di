package spring.svg.di.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.svg.di.sfgdi.services.GreetingServiceImpl;

@Controller
public class SetterInjectedController {
    private GreetingServiceImpl greetingService;

    @Autowired
    public void setGreetingService(GreetingServiceImpl greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
