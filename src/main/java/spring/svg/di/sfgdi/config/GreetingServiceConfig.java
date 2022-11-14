package spring.svg.di.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import spring.svg.di.sfgdi.datasource.FakeDataSource;
import spring.svg.di.sfgdi.repositories.EnglishGreetingRepository;
import spring.svg.di.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import spring.svg.di.sfgdi.services.*;
import svg.pets.PetService;
import svg.pets.PetServiceFactory;

@PropertySource("classpath:datasource.properties")
//@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {


    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
                                  @Value("${guru.password}") String password,
                                  @Value("${guru.jdbcUrl}") String jdbcUrl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

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
