package Views;

import DAO.Domain.FlightInstance;
import com.yammer.dropwizard.views.View;

import java.util.List;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class AvailableSeatsQueryView extends View{
    private List<FlightInstance> flightInstances;

    public AvailableSeatsQueryView(List<FlightInstance> flightInstances) {
        super("AvailableSeatsQuery.mustache");
        this.flightInstances=flightInstances;
    }

    public List<FlightInstance> getFlightInstances() {
        return flightInstances;
    }
}
