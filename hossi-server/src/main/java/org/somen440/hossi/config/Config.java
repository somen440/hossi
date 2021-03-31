package org.somen440.hossi.config;

import javax.inject.Singleton;

@Singleton
public class Config {

  public static String gcpProjectId = System.getenv("GCP_PROJECT_ID");
}
