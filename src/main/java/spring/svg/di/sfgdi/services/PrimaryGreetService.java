package spring.svg.di.sfgdi.services;

public class PrimaryGreetService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world -  from the primary bean";
    }
}
