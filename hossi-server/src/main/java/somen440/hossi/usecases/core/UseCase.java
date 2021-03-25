package somen440.hossi.usecases.core;

public interface UseCase<TInputData extends InputData<TOutputData>, TOutputData extends OutputData> {
    TOutputData handle(TInputData inputData);
}
