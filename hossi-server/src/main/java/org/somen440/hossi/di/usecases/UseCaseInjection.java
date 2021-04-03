package org.somen440.hossi.di.usecases;

public class UseCaseInjection {

  private static UseCaseType type = UseCaseType.NORMAL;

  public static void useNormal() {
    type = UseCaseType.NORMAL;
  }

  public static void useError() {
    type = UseCaseType.ERROR;
  }

  public static UseCaseType currentType() {
    return type;
  }
}
