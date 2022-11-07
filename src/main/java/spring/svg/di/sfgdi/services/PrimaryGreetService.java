package spring.svg.di.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryGreetService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world -  from the primary bean";
    }
}
