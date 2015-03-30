package Views;

import com.yammer.dropwizard.views.View;

import java.util.List;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class AirportCodeQueryView extends View{
    private final List<String> airportCodes;

    public AirportCodeQueryView(List<String> airportCodes) {
        super("FlightsQuery.mustache");
        this.airportCodes=airportCodes;
    }

    public List<String> getAirportCodes() {
        return airportCodes;
    }
}
