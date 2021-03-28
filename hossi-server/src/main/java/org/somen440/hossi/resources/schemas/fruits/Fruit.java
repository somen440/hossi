package org.somen440.hossi.resources.schemas.fruits;

public class Fruit {

    public int id;
    public String name;
    public String description;

    public Fruit() {}

    public Fruit(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
