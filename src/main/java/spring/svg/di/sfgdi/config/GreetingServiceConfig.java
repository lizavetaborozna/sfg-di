package spring.svg.di.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import spring.svg.di.sfgdi.repositories.EnglishGreetingRepository;
import spring.svg.di.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import spring.svg.di.sfgdi.services.*;

@Configuration
public class GreetingServiceConfig {

    @Bean("i18Service")
    @Profile({"ES", "default"})
    I18SpanishGreetingService i18SpanishGreetingService() {
        return new I18SpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean
    @Profile("EN")
    I18EnglishGreetingService i18Service(EnglishGreetingRepository englishGreetingRepository) {
        return new I18EnglishGreetingService(englishGreetingRepository);
    }

    @Bean
    @Primary
    PrimaryGreetService primaryGreetService() {
        return new PrimaryGreetService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
