package org.somen440.hossi.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

  private static final Logger LOG = Logger.getLogger(RuntimeExceptionMapper.class);

  @Override
  public Response toResponse(RuntimeException e) {
    LOG.error(e);
    var status = Response.Status.INTERNAL_SERVER_ERROR;
    return Response.status(status).entity(status.toString()).build();
  }
}
