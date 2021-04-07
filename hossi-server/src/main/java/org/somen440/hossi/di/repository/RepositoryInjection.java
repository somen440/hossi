package org.somen440.hossi.di.repository;

import javax.inject.Singleton;

@Singleton
public class RepositoryInjection {

  private static RepositoryType type = RepositoryType.FIRESTORE;

  public static void useInmemory() {
    type = RepositoryType.INMEMORY;
  }

  public static void useMock() {
    type = RepositoryType.MOCK;
  }

  public static void useFirestore() { type = RepositoryType.FIRESTORE; }

  public static RepositoryType currentType() {
    return type;
  }
}
