package resource;


import DAO.Domain.Flight;
import DAO.FlightDAO;
import Views.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Path(value = "/flight")
public class FlightResource {


    private FlightDAO flightDAO;

    public FlightResource(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    @GET
    @Path("/fare")
    public Response fareDetails() throws URISyntaxException {
        return Response.ok().entity(new FlightFareQueryView(flightDAO.getFlightNumbers())).build();
    }

    @GET
    @Path("/getFareDetails")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response getFareDetails(@QueryParam("flight_number") String flightNumber) {
        return Response.ok().entity(new FlightView(flightDAO.getFareDetails(flightNumber))).build();
    }


    @GET
    @Path("/flightInstances")
    public Response flightInstances() throws URISyntaxException {
        return Response.ok().entity(new PassengerDetailsQueryView(flightDAO.getFlightInstances())).build();
    }


    @GET
    @Path("/listPassengerDetails")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response listPassengerDetails(@QueryParam("flight_instance") String flightInstance) {
        String[] splitFlightInstances = flightInstance.split("_");
        return Response.ok().entity(new PassengerDetailsView(flightDAO.getCustomerDetails(splitFlightInstances[0], splitFlightInstances[1]))).build();
    }


    @GET
    @Path("/passengerDetails")
    public Response passenger() throws URISyntaxException {
        return Response.ok().entity(new FlightInstanceQueryView(flightDAO.getCustomerNames())).build();
    }


    @GET
    @Path("/listFlightInstances")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response listFlightInstances(@QueryParam("passengerName") String name) {
        return Response.ok().entity(new FlightInstanceView(flightDAO.getFlightInstanceDetails(name))).build();
    }


    @GET
    @Path("/queryAvailableSeats")
    public Response queryAvailableSeats() throws URISyntaxException {
        return Response.ok().entity(new AvailableSeatsQueryView(flightDAO.getFlightInstances())).build();
    }


    @GET
    @Path("/listAvailableSeats")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response listAvailableSeats(@QueryParam("flight_instance") String flightInstance) {
        String[] splitFlightInstances = flightInstance.split("_");
        return Response.ok().entity(new AvailableSeatsView(flightDAO.getAvailableSeats(splitFlightInstances[0], splitFlightInstances[1]))).build();
    }


    @GET
    @Path("/queryFlights")
    public Response queryFlights() throws URISyntaxException {
        return Response.ok().entity(new FlightsQueryView(flightDAO.getAirportCodes())).build();
    }


    @GET
    @Path("/fetchFlights")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response fetchFlights(@QueryParam("from_airport_code") String fromAirportCode,
                                 @QueryParam("to_airport_code") String toAirportCode, @QueryParam("no_of_legs") int legCount) {
        List<List<Flight>> flightsBasedOnAirportCode = new ArrayList<>();
        if (legCount == 0) {
            flightsBasedOnAirportCode = flightDAO.getDirectFlights(fromAirportCode, toAirportCode);
        }else if (legCount == 1) {
            flightsBasedOnAirportCode = flightDAO.getFlightsWithOneLeg(fromAirportCode, toAirportCode);
        }else if (legCount == 2) {
            flightsBasedOnAirportCode = flightDAO.getFlightsWithTwoLeg(fromAirportCode, toAirportCode);
        }
        List<Flight> flights = flightsBasedOnAirportCode.get(0);

        String replacedString = "_".concat(flights.get(0).getWeekdays().concat("_")).replace("_", ".*");
        String replacedString1 = "_".concat(flights.get(1).getWeekdays().concat("_")).replace("_", ".*");
        System.out.println("***********"+replacedString);
        System.out.println("***********"+replacedString1);
        System.out.println("***********"+replacedString.matches(replacedString1));

        return Response.ok().entity(new FetchFlightsView(flightsBasedOnAirportCode)).build();
    }


}
