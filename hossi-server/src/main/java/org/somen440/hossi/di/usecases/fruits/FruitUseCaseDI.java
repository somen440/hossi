package org.somen440.hossi.di.usecases.fruits;

import org.somen440.hossi.usecases.fruits.list.FruitListUseCase;
import org.somen440.hossi.di.repository.fruits.FruitRepositoryDI;
import org.somen440.hossi.domain.application.fruit.FruitAddInteractor;
import org.somen440.hossi.domain.application.fruit.FruitDeleteInteractor;
import org.somen440.hossi.domain.application.fruit.FruitListInteractor;
import org.somen440.hossi.usecases.fruits.add.FruitAddUseCase;
import org.somen440.hossi.usecases.fruits.delete.FruitDeleteUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FruitUseCaseDI {
    @Inject
    FruitRepositoryDI fruitRepositoryDI;

    public FruitAddUseCase addUseCase() {
        return new FruitAddInteractor(fruitRepositoryDI.repository());
    }

    public FruitListUseCase listUseCase() {
        return new FruitListInteractor(fruitRepositoryDI.repository());
    }

    public FruitDeleteUseCase deleteUseCase() {
        return new FruitDeleteInteractor(fruitRepositoryDI.repository());
    }
}
