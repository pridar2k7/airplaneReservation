package Views;

import DAO.Domain.Flight;
import com.yammer.dropwizard.views.View;

import java.util.List;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class FetchFlightsView extends View{
    private final List<Flight> flights;

    public FetchFlightsView(List<Flight> flightsBasedOnAirportCode) {
        super("FlightDetails.mustache");
        this.flights = flightsBasedOnAirportCode;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
