package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class App {
    public static void main( String[] args ) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Context loaded");

        // получение объекта по bean id
        HelloWorldWriter writer = (HelloWorldWriter) context.getBean("helloWorldWriter");
        HelloWorldWriter writer2 = (HelloWorldWriter) context.getBean("helloWorldWriter");

        // переменные writer и writer2 ссылаются на один и тот же объект так как по дефолту scope = singleton, 1 объект на все приложение
        // Сколько бы раз не запросили из контекста вернется один и тот же объект
        // если изменить через аннотацию Scope на prototype то каждый раз запрашивая из контекста объект будет возвращаться новый экземпляр
        System.out.println("***writer == writer2 : " + (writer == writer2));

        // получение объекта по bean id из AppConf
        HelloWorldWriter writer3 = (HelloWorldWriter) context.getBean("helloWorldWriter2");
        writer3.write();

        // в контексте находится 2 объекта с одним и тем же типом IMessageProvider
        Map<String, IMessageProvider> providers = context.getBeansOfType(IMessageProvider.class);
        System.out.println("***Context has " + providers.size() + " objects with IMessageProvider type:");
        providers.forEach((key, value) -> System.out.println("***key (bean id): " + key + ", value (object): " + value));

        context.registerShutdownHook();
    }
}
