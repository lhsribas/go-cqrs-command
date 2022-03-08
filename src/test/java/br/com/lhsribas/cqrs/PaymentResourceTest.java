package br.com.lhsribas.cqrs;

import br.com.lhsribas.cqrs.app.dto.PaymentRequest;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PaymentResourceTest {

    @Test
    public void testsaveEndpoint() {
        var request = new PaymentRequest();
        request.setLatitude(34234243.4);
        request.setLongitude(2345235.6);
        request.setProduct("Nike SB Premium");
        request.setValue(new BigDecimal(650));

        given()
                .body(request)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().post("/payments/save")
          .then()
             .statusCode(200);
    }

}
