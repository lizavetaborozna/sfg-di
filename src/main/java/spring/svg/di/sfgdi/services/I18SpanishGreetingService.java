package spring.svg.di.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ES")
@Service("i18Service")
public class I18SpanishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - SPANISH";
    }
}
