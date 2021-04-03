package org.somen440.hossi.di.repository;

import javax.inject.Singleton;

@Singleton
public class RepositoryInjection {

  private static RepositoryType type = RepositoryType.FIREBASE;

  public static void useFirebase() {
    type = RepositoryType.FIREBASE;
  }

  public static void useInmemory() {
    type = RepositoryType.INMEMORY;
  }

  public static void useMock() {
    type = RepositoryType.MOCK;
  }

  public static RepositoryType currentType() {
    return type;
  }
}
