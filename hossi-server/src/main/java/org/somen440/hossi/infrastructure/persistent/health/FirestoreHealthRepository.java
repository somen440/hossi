package org.somen440.hossi.infrastructure.persistent.health;

import com.google.cloud.firestore.Firestore;
import java.util.concurrent.ExecutionException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.somen440.hossi.domain.model.health.HealthModel;
import org.somen440.hossi.domain.model.health.HealthRepository;

@ApplicationScoped
public class FirestoreHealthRepository implements HealthRepository {

  private static final String service = "firestore";
  private static final String collectionName = "health";
  private static final String checkDocumentID = "check";

  @Inject Firestore firestore;

  public FirestoreHealthRepository() {}

  @Override
  public HealthModel check() throws ExecutionException, InterruptedException {
    var result = firestore.collection(collectionName).document(checkDocumentID).get();
    if (!result.get().exists()) {
      return new HealthModel(service, false);
    }
    return new HealthModel(service, true);
  }
}
