package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;

@Component
//@Scope("prototype")
public class HelloWorldWriter {

    // Работаем в классе от интерфейса, создаем слабосвязанный код
    private IMessageProvider provider;

    @Value("${fileName}")
    private String fileName;

    public HelloWorldWriter() {
        System.out.println("HelloWorldWriter constructor without args initializing... provider = " + provider + " fileName = " + fileName);
    }

    //@Autowired
    public HelloWorldWriter(@Qualifier("anotherProvider") IMessageProvider provider) {
        this.provider = provider;
        System.out.println("HelloWorldWriter constructor with 1 args initializing... provider = " + provider + " fileName = " + fileName);
    }

    @Autowired
    public HelloWorldWriter(@Qualifier("helloWorldProvider") IMessageProvider provider, @Value("${fileName}") String fileName) {
        this.provider = provider;
        System.out.println("HelloWorldWriter constructor with 2 args initializing... provider = " + provider + " fileName = " + fileName);
    }

    public void write() {
        System.out.println("***Result");

        if (Objects.isNull(provider)) {
            System.out.println("Error: provider isn't initialized... provider = " + provider);
        } else {
            System.out.println(provider.getMessage());
        }
    }

    // внедрение через setter
    //@Autowired
    public void setProvider(@Qualifier("anotherProvider") IMessageProvider provider) {
        this.provider = provider;
        System.out.println("initializing provider via setter... provider = " + provider);
    }

    // внедрение через setter
    //@Autowired
    public void setFileName(@Value("${fileName}") String fileName) {
        this.fileName = fileName;
        System.out.println("initializing file name via setter... file name = " + fileName);
    }

    public String getText() {
        return provider.getMessage();
    }

    @PostConstruct
    public void initWriter() {
        System.out.println("start bean initializing...");
        System.out.println("stop bean initializing...");
    }

    @PreDestroy
    public void destroyWriter() {
        System.out.println("start bean destroying...");
        System.out.println("stop bean destroying...");
    }
}
