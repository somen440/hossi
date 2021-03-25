package somen440.hossi.usecases.fruits.delete;

import somen440.hossi.usecases.core.InputData;

public class FruitDeleteInputData implements InputData<FruitDeleteOutputData> {

    public int id;

    public FruitDeleteInputData() {
    }

    public FruitDeleteInputData(int id) {
        this.id = id;
    }
}
