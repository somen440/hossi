package org.somen440.hossi.infrastructure.persistent.fruit;

import com.google.cloud.firestore.Firestore;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.jboss.logging.Logger;
import org.somen440.hossi.domain.model.fruit.FruitModel;
import org.somen440.hossi.domain.model.fruit.FruitRepository;

@ApplicationScoped
public class FirestoreFruitRepository implements FruitRepository {

  private static final Logger LOG = Logger.getLogger(FirestoreFruitRepository.class);

  private static final String collectionName = "fruits";

  @Inject Firestore firestore;

  @Override
  public FruitModel save(String name, String description)
      throws ExecutionException, InterruptedException {
    var collectionRef = firestore.collection(collectionName);

    var data = new HashMap<>();
    data.put("name", name);
    data.put("description", description);

    var result = collectionRef.add(data);

    LOG.debug(String.format("成功 id=%s", result.get().getId()));

    return new FruitModel(result.get().getId(), name, description);
  }

  @Override
  public void remove(String id) {
    var collectionRef = firestore.collection(collectionName);
    collectionRef.document(id).delete();
  }

  @Override
  public Set<FruitModel> findAll() throws ExecutionException, InterruptedException {
    var results = new HashSet<FruitModel>();

    var collectionRef = firestore.collection(collectionName).get().get().getDocuments();

    for (var document : collectionRef) {
      var fruit =
          new FruitModel(
              document.getId(), document.getString("name"), document.getString("description"));
      results.add(fruit);
    }

    LOG.debug(String.format("findAll 成功 length=%d", results.size()));

    return results;
  }
}
