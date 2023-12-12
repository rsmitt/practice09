package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context.xml");
        System.out.println("Context loaded");

        //HelloWorldProvider provider = context.getBean(HelloWorldProvider.class);
        //System.out.println("Direct call HelloWorldProvider: " + provider.getMessage());

        HelloWorldWriter writer = context.getBean(HelloWorldWriter.class);
        writer.write();

        context.registerShutdownHook();
    }
}
