package org.somen440.hossi.infrastructure.persistent.fruit;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.google.cloud.firestore.Firestore;
import org.jboss.logging.Logger;
import org.somen440.hossi.domain.model.fruit.FruitModel;
import org.somen440.hossi.domain.model.fruit.FruitRepository;

@ApplicationScoped
public class FirebaseFruitRepository implements FruitRepository {

  private static final Logger LOG = Logger.getLogger(FirebaseFruitRepository.class);

  private static final String collectionName = "fruits";

  private Firestore db;

  public FirebaseFruitRepository() {}

  public FirebaseFruitRepository(Firestore db) {
    this.db = db;
  }

  @Override
  public FruitModel save(String name, String description) throws Exception {
    var docRef = db.collection(collectionName);

    var data = new HashMap<>();
    data.put("name", name);
    data.put("description", description);

    var result = docRef.add(data);

    LOG.debug(String.format("成功 id=%s", result.get().getId()));

    return new FruitModel(result.get().getId(), name, description);
  }

  @Override
  public void remove(String id) {
    var docRef = db.collection(collectionName);
    docRef.document(id).delete();
  }

  @Override
  public Set<FruitModel> findAll() throws Exception {
    Set<FruitModel> results = new HashSet<>();

    var documents = db.collection(collectionName).get().get().getDocuments();

    for (var document : documents) {
      var fruit =
          new FruitModel(
              document.getId(), document.getString("name"), document.getString("description"));
      results.add(fruit);
    }

    LOG.debug(String.format("findAll 成功 length=%d", results.size()));

    return results;
  }
}
