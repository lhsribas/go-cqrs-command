package br.com.lhsribas.cqrs.app;

import br.com.lhsribas.cqrs.app.dto.PaymentRequest;
import br.com.lhsribas.cqrs.app.service.PaymentService;
import io.quarkus.vertx.web.Body;
import io.quarkus.vertx.web.Route;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import org.jboss.resteasy.spi.ResteasyAsynchronousResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

//@ApplicationScoped
@Path("/payments")
public class PaymentResource {

    @Inject
    private PaymentService service;


    @GET
    @Path("/save")
    Response savePayment(@Body PaymentRequest request){
        //service.Save(request);

        return Response.status(200).build();
    }
    /*
    @Route(path = "/payments/save", methods = Route.HttpMethod.POST)
    void savePayment(@Body PaymentRequest request, RoutingContext rc){

        Uni.createFrom().emitter(service.Save());
        service.Save(request);
        rc.response().setStatusCode(200).end();
    }

    @Route(type = Route.HandlerType.FAILURE)
    void unsupported(UnsupportedOperationException e, HttpServerResponse response) {
        response.setStatusCode(501).end(e.getMessage());
    }

    @Route(path = "/payments/hello", methods = Route.HttpMethod.GET)
    void helloPayment(RoutingContext rc){
        rc.response().setStatusCode(200).end("hello");
    }
    */

}
