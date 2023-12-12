package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Value("${fileName}")
    private String fileName;

    @Bean("anotherProvider2")
    public IMessageProvider anotherProvider2() {
        return new AnotherProvider();
    }

    @Bean("helloWorldWriter2")
    public HelloWorldWriter helloWorldWriter2() {
        return new HelloWorldWriter(anotherProvider2(), fileName);
    }
}
