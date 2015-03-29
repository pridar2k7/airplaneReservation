package Views;

import DAO.Domain.FlightInstance;
import com.yammer.dropwizard.views.View;

import java.util.List;

/**
 * Created by priyadarshini on 3/27/15.
 */
public class PassengerDetailsQueryView extends View {
    private final List<FlightInstance> flightInstances;

    public PassengerDetailsQueryView(List<FlightInstance> flightInstances) {
        super("FlightInstance.mustache");
        this.flightInstances = flightInstances;
    }

    public List<FlightInstance> getFlightInstances() {
        return flightInstances;
    }
}
