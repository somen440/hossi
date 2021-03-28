package org.somen440.hossi.usecases;

public interface UseCase<TInputData extends InputData<TOutputData>, TOutputData extends OutputData> {
    TOutputData handle(TInputData inputData);
}
