package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    CarController carController;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String cars = restTemplate.getForObject("http://localhost:8080", String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(cars);
        System.out.println("Rest service response: " + cars);
        System.out.println("Fist car name: " + node.get(0).get("name").asText() + " color: " + node.get(0).get("options").get("color").asText());
        System.out.println("Second car name: " + node.get(1).get("name").asText() + " color: " + node.get(1).get("options").get("color").asText());
    }
}
