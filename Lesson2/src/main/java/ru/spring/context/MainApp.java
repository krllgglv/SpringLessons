package ru.spring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spring.context.config.AppConfig;
import ru.spring.context.console.ConsoleReader;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        var consoleReader = context.getBean("consoleReader", ConsoleReader.class);
        consoleReader.start();
    }

}
