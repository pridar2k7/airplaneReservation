package resource;


import DAO.Domain.Flight;
import DAO.Domain.FlightInstance;
import DAO.FlightDAO;
import Views.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Path(value = "/flight")
public class FlightResource {


    private FlightDAO flightDAO;

    public FlightResource(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    @GET
    public Response home() throws URISyntaxException {
        return Response.ok().entity(new HomeView()).build();
    }

    @GET
    @Path("/getFlightNumbers")
    public Response getFlightNumbers() throws URISyntaxException {
        return Response.ok().entity(new FlightFareQueryView(flightDAO.getFlightNumbers())).build();
    }

    @GET
    @Path("/getFareDetails")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response getFareDetails(@QueryParam("flight_number") String flightNumber) {
        return Response.ok().entity(new FlightFareView(flightDAO.getFareDetails(flightNumber))).build();
    }

    @GET
    @Path("/getFlightInstances")
    public Response flightInstances(@QueryParam("toFetch") String toFetch) throws URISyntaxException {
        return Response.ok().entity(new FlightInstancesView(flightDAO.getFlightInstances(), toFetch)).build();
    }


    @GET
    @Path("/getPassengerDetails")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response getPassengerDetails(@QueryParam("flight_instance") String flightInstance) {
        String[] splitFlightInstances = flightInstance.split("_");
        return Response.ok().entity(new PassengerDetailsView(flightDAO.getCustomerDetails(splitFlightInstances[0], splitFlightInstances[1]))).build();
    }


    @GET
    @Path("/getCustomerNames")
    public Response getCustomerNames() throws URISyntaxException {
        return Response.ok().entity(new CustomerNamesView(flightDAO.getCustomerNames())).build();
    }


    @GET
    @Path("/listFlightInstances")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response listFlightInstances(@QueryParam("passengerName") String name) {
        List<FlightInstance> flightInstanceDetails = flightDAO.getFlightInstanceDetails(name);
        return Response.ok().entity(new ListFlightInstanceView(flightInstanceDetails)).build();
    }


    @GET
    @Path("/getAvailableSeats")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response listAvailableSeats(@QueryParam("flight_instance") String flightInstance) {
        String[] splitFlightInstances = flightInstance.split("_");
        return Response.ok().entity(new AvailableSeatsView(flightDAO.getAvailableSeats(splitFlightInstances[0], splitFlightInstances[1]))).build();
    }


    @GET
    @Path("/getAirportCodes")
    public Response getAirportCodes() throws URISyntaxException {
        return Response.ok().entity(new AirportCodeQueryView(flightDAO.getAirportCodes())).build();
    }


    @GET
    @Path("/getConnectingFlights")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response getConnectingFlights(@QueryParam("from_airport_code") String fromAirportCode,
                                 @QueryParam("to_airport_code") String toAirportCode, @QueryParam("no_of_legs") int legCount) {
        List<Flight> flightsBasedOnAirportCode = new ArrayList<>();
        if (legCount == 0) {
            flightsBasedOnAirportCode = flightDAO.getDirectFlights(fromAirportCode, toAirportCode);
        }else if (legCount == 1) {
            flightsBasedOnAirportCode = flightDAO.getFlightsWithOneLeg(fromAirportCode, toAirportCode);
        }else if (legCount == 2) {
            flightsBasedOnAirportCode = flightDAO.getFlightsWithTwoLeg(fromAirportCode, toAirportCode);
        }
        for (Flight flight : flightsBasedOnAirportCode) {
            List<String> weekdays = flight.getWeekdays();
            List retainedArrayList = new ArrayList();
            for (String weekday : weekdays) {
                String[] split = weekday.split("_");
                ArrayList arrayList = new ArrayList();
                Collections.addAll(arrayList, split);
                if(retainedArrayList.isEmpty()){
                    retainedArrayList=arrayList;
                } else{
                    retainedArrayList.retainAll(arrayList);
                }

            }
            flight.setWeekdays(retainedArrayList);
//
//            ArrayList arrayList1 = new ArrayList();
//            String[] split1 = flights.get(1).getWeekdays().split("_");
//            Collections.addAll(arrayList1, split1);
//            System.out.println(arrayList1.toString());
//            System.out.println(arrayList1);
        }

        return Response.ok().entity(new FlightsView(flightsBasedOnAirportCode)).build();
    }


}
