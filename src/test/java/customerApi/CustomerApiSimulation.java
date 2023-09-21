package customerApi;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.core.ScenarioBuilder.*;
import scala.concurrent.duration.*;


public class CustomerApiSimulation {
 //http config
    private HttpProtocolBuilder httpProtocol = http
         .baseUrl("https://linetencustomerapi.azurewebsites.net/Api")
         .acceptHeader("application/json");

   // Scenario Definition
   private ScenarioBuilder scn = scenario("LineTen Customer Api performance test")
           .exec(http("Get all Ids")
                   .get("/get"));
   // Load simulation
   {
       setUp(scn.injectOpen(atOnceUsers(1))
               .protocols(httpProtocol));
   }
    private void setUp(PopulationBuilder protocols) {
    }

}
