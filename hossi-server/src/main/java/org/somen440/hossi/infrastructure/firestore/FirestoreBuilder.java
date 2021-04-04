package org.somen440.hossi.infrastructure.firestore;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import java.io.IOException;
import org.somen440.hossi.config.Config;

public class FirestoreBuilder {

  public static Firestore build() throws IOException {
    FirestoreOptions firestoreOptions =
        FirestoreOptions.getDefaultInstance().toBuilder()
            .setProjectId(Config.gcpProjectId)
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .build();
    return firestoreOptions.getService();
  }
}
