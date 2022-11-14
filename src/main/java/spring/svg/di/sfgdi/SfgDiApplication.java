package spring.svg.di.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import spring.svg.di.sfgdi.controllers.*;
import spring.svg.di.sfgdi.datasource.FakeDataSource;
import spring.svg.di.sfgdi.services.PrototypeBean;
import spring.svg.di.sfgdi.services.SingletonBean;

@SpringBootApplication
//@ComponentScan(basePackages = {"spring.svg.di.sfgdi", "svg.pets"})
public class SfgDiApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println(petController.whichPetIsTheBest());

        I18Controller i18Controller = (I18Controller) ctx.getBean("i18Controller");
        System.out.println(i18Controller.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");
        System.out.println(myController.sayHello());

        System.out.println("---------------------Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("---------------------Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());
        System.out.println("---------------------Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("-----------------Bean scopes ---------------------------------------");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());

        System.out.println("__________Data source_____________________________________________________");
        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcUrl());
    }

}
