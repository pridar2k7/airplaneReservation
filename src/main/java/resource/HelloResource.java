package resource;


import DAO.Fare;
import DAO.UniversityDAO;
import Views.UniversityView;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import config.MessagesConfiguration;
import org.json.simple.JSONArray;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path(value = "/hello")
public class HelloResource {


    private UniversityDAO universityDAO;
    private MessagesConfiguration conf;

    public HelloResource(MessagesConfiguration conf, UniversityDAO universityDAO) {
        this.conf = conf;
        this.universityDAO=universityDAO;
    }

    @GET
    public String sayHello() {
        return conf.getHello();
    }

    @GET
    @Path("/name")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response sayName() throws JsonProcessingException {
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(universityDAO.getFareDetails());
        return Response.ok().entity(new UniversityView(universityDAO.getFareDetails())).build();
//    return universityDAO.getFareDetails();
    }

}
