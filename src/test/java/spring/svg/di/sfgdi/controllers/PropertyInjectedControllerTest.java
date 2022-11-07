package spring.svg.di.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.svg.di.sfgdi.services.GreetingServiceImpl;


class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new GreetingServiceImpl();

    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}
