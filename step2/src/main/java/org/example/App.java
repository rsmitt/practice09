package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context.xml");
        System.out.println("Context loaded");

        HelloWorldWriter writer = context.getBean(HelloWorldWriter.class);
        writer.write();

        context.registerShutdownHook();
    }
}
