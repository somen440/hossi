package org.somen440.hossi.infrastructure.persistent.fruit;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.google.cloud.firestore.Firestore;
import org.jboss.logging.Logger;
import org.somen440.hossi.domain.model.fruit.FruitModel;
import org.somen440.hossi.domain.model.fruit.FruitRepository;

public class FirebaseFruitRepository implements FruitRepository {

  private static final Logger LOG = Logger.getLogger(InMemoryFruitRepository.class);

  private static final String collectionName = "fruits";

  private Firestore db;

  public FirebaseFruitRepository() {}

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

    var documents = db.collection(collectionName)
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
