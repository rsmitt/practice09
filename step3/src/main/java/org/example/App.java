package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context.xml");
        System.out.println("Context loaded");

        HelloWorldWriter writer = context.getBean(HelloWorldWriter.class);
        writer.write();

        // в контексте находится 2 объекта с одним и тем же типом IMessageProvider
        Map<String, IMessageProvider> providers = context.getBeansOfType(IMessageProvider.class);
        System.out.println("***Context has " + providers.size() + " objects with IMessageProvider type:");
        providers.forEach((key, value) -> System.out.println("***key (bean id): " + key + ", value (object): " + value));

        context.registerShutdownHook();
    }
}
