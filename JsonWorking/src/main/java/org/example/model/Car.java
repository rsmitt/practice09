package org.example.model;

import java.util.Map;

public class Car {

    private Integer id;
    private String name;
    private Map<String, String> options;

    public Car() {
    }

    public Car(Integer id, String name, Map<String, String> options) {
        this.id = id;
        this.name = name;
        this.options = options;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", options=" + options +
                '}';
    }
}
