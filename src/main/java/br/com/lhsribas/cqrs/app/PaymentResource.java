package br.com.lhsribas.cqrs.app;

/*
import br.com.lhsribas.cqrs.app.dto.PaymentRequest;
import br.com.lhsribas.cqrs.app.mapper.EPaymentMapper;
import br.com.lhsribas.cqrs.app.service.PaymentService;
import br.com.lhsribas.cqrs.infra.db.model.Payment;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.vertx.web.Body;
import io.quarkus.vertx.web.Route;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import org.jboss.resteasy.spi.ResteasyAsynchronousResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@ApplicationScoped
public class PaymentResource {

    @Inject
    private PaymentService service;

    @Route(path = "/payments/save", methods = Route.HttpMethod.POST)

    Uni<Response> savePayment(@Body PaymentRequest request){
        return Uni.createFrom().item(service.save(request))
                .onFailure()
                    .recoverWithItem(err -> Response.status(500))
                .onItem().apply(Response.ResponseBuilder::build)
                .emitOn(Infrastructure.getDefaultExecutor());
    }

    @Route(type = Route.HandlerType.FAILURE)
    void unsupported(UnsupportedOperationException e, HttpServerResponse response) {
        response.setStatusCode(501).end(e.getMessage());
    }

    @Route(path = "/payments/hello", methods = Route.HttpMethod.GET)
    Uni<String> helloPayment(RoutingContext rc){
        return Uni.createFrom().item("Hello");
    }
}

 */

import br.com.lhsribas.cqrs.app.dto.PaymentRequest;
import br.com.lhsribas.cqrs.app.service.PaymentService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/payments")
public class PaymentResource{

    @Inject
    private PaymentService service;

    @POST
    @Path("/save")
    public Response save(final PaymentRequest request){
        try{
            return Response.status(Response.Status.CREATED).entity(service.save(request)).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getCause()).build();
        }
    }

}
