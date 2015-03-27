package resource;


import DAO.FlightDAO;
import Views.FlightFareQueryView;
import Views.FlightView;
import com.fasterxml.jackson.core.JsonProcessingException;
import config.MessagesConfiguration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;


@Path(value = "/flight")
public class FlightResource {


    private FlightDAO flightDAO;
    private MessagesConfiguration conf;

    public FlightResource(MessagesConfiguration conf, FlightDAO flightDAO) {
        this.conf = conf;
        this.flightDAO = flightDAO;
    }

    @GET
    public String sayHello() {
        return conf.getHello();
    }

    @GET
    @Path("/fare")
    public Response fareDetails() throws URISyntaxException {
        return Response.ok().entity(new FlightFareQueryView(flightDAO.getFlightNumbers())).build();
    }

    @GET
    @Path("/getFareDetails")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response getFareDetails(@QueryParam("flight_number") String flightNumber) throws JsonProcessingException {
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(universityDAO.getFareDetails());
        System.out.println("****************" + flightNumber);
        return Response.ok().entity(new FlightView(flightDAO.getFareDetails(flightNumber))).build();
//    return universityDAO.getFareDetails();
    }

}
