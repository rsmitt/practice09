package org.example;

import java.util.Objects;

public class HelloWorldWriter {

    // Работаем в классе от интерфейса, создаем слабосвязанный код
    private IMessageProvider provider;
    private String fileName;

    public HelloWorldWriter() {
        System.out.println("HelloWorldWriter constructor without args initializing... provider = " + provider + " fileName = " + fileName);
    }

    public HelloWorldWriter(IMessageProvider provider) {
        this.provider = provider;
        System.out.println("HelloWorldWriter constructor with 1 args initializing... provider = " + provider + " fileName = " + fileName);
    }

    public HelloWorldWriter(IMessageProvider provider, String fileName) {
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

    public void setProvider(IMessageProvider provider) {
        this.provider = provider;
        System.out.println("initializing provider via setter... provider = " + provider);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        System.out.println("initializing file name via setter... file name = " + fileName);
    }

    public void initWriter() {
        System.out.println("start bean initializing...");
        System.out.println("stop bean initializing...");
    }

    public void destroyWriter() {
        System.out.println("start bean destroying...");
        System.out.println("stop bean destroying...");
    }
}
