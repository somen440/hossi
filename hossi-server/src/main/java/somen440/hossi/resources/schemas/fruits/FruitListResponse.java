package somen440.hossi.resources.schemas.fruits;

import java.util.Set;

public class FruitListResponse {

    public Set<Fruit> fruits;

    public FruitListResponse() {}

    public FruitListResponse(Set<Fruit> fruits) {
        this.fruits = fruits;
    }
}
