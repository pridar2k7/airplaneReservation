package Views;

import DAO.Domain.FlightInstance;
import com.yammer.dropwizard.views.View;

import java.util.List;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class FlightInstanceView extends View{
    private List<FlightInstance> flightInstanceDetails;

    public FlightInstanceView(List<FlightInstance> flightInstanceDetails) {
        super("FlightInstanceDetails.mustache");
        this.flightInstanceDetails = flightInstanceDetails;
    }

    public List<FlightInstance> getFlightInstanceDetails() {
        return flightInstanceDetails;
    }
}
