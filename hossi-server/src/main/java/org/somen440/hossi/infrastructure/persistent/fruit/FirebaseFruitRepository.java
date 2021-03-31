package org.somen440.hossi.infrastructure.persistent.fruit;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.jboss.logging.Logger;
import org.somen440.hossi.config.Config;
import org.somen440.hossi.domain.model.fruit.FruitModel;
import org.somen440.hossi.domain.model.fruit.FruitRepository;

public class FirebaseFruitRepository implements FruitRepository {

  final String COLLECTION_NAME = "fruits";

  final private Firestore db;

  private static final Logger LOG = Logger.getLogger(InMemoryFruitRepository.class);

  public FirebaseFruitRepository(Firestore db) {
    this.db = db;
  }

  @Override
  public FruitModel save(String name, String description) {
    return null;
  }

  @Override
  public void remove(int id) {

  }

  @Override
  public Set<FruitModel> findAll() throws Exception {
    Set<FruitModel> results = new HashSet<>();

    var documents = db.collection(COLLECTION_NAME)
        .get().get().getDocuments();

    for (var document : documents) {
      var fruit = new FruitModel(
          Objects.requireNonNull(document.getDouble("id")).intValue(),
          document.getString("name"),
          document.getString("description")
      );
      results.add(fruit);
    }

    LOG.debug(String.format("findAll 成功 length=%d", results.size()));

    return results;
  }
}
