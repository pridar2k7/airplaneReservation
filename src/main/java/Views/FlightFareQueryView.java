package Views;

import com.yammer.dropwizard.views.View;

import java.util.List;

/**
 * Created by priyadarshini on 3/26/15.
 */
public class FlightFareQueryView extends View{
    private final List<String> flightNumbers;

    public FlightFareQueryView(List<String> flightNumbers) {
        super("FlightFareQuery.mustache");
        this.flightNumbers = flightNumbers;
    }

    public List<String> getFlightNumbers() {
        return flightNumbers;
    }
}
