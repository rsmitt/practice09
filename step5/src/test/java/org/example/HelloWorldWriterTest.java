package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldWriterTest {

    @Test
    void checkHelloWorldProviderMessage() {
        HelloWorldWriter writer = new HelloWorldWriter(new HelloWorldProvider(), "application.properties");
        assertEquals(writer.getText(), "Hello from HelloWorldProvider");
    }

    @Test
    void checkAnotherProviderMessage() {
        HelloWorldWriter writer = new HelloWorldWriter(new AnotherProvider(), "application.properties");
        assertEquals(writer.getText(), "Some message from AnotherProvider");
     }
}