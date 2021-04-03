package org.somen440.hossi.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

@Provider
public class InvalidArgumentExceptionMapper implements ExceptionMapper<InvalidArgumentException> {

  private static final Logger LOG = Logger.getLogger(RuntimeExceptionMapper.class);

  @Override
  public Response toResponse(InvalidArgumentException e) {
    LOG.warn(e);
    var status = Response.Status.BAD_REQUEST;
    return Response.status(status).entity(status.toString()).build();
  }
}
