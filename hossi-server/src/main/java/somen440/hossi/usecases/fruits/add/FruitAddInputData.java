package somen440.hossi.usecases.fruits.add;

import somen440.hossi.usecases.core.InputData;

public class FruitAddInputData implements InputData<FruitAddOutputData> {

    public String name;
    public String description;

    public FruitAddInputData() {
    }

    public FruitAddInputData(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
