package org.somen440.hossi.resources;

import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.somen440.hossi.di.usecases.health.HealthUseCaseDi;
import org.somen440.hossi.exception.RuntimeException;
import org.somen440.hossi.resources.schemas.health.Health;
import org.somen440.hossi.resources.schemas.health.HealthCheckResponse;
import org.somen440.hossi.usecases.health.check.HealthCheckInputData;

@Path("/health")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HealthResource {

  @Inject
  HealthUseCaseDi di;

  /**
   * ヘルスチェックを行う
   *
   * @return レスポンス（外部サービスとの接続結果）
   * @throws RuntimeException 500
   */
  @GET
  public HealthCheckResponse check() throws RuntimeException {
    Set<Health> results;

    try {
      var output = di.checkUseCase().handle(new HealthCheckInputData());
      results =
          output.results.stream().map(r -> new Health(r.service, r.ok)).collect(Collectors.toSet());
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }

    return new HealthCheckResponse(results);
  }
}
