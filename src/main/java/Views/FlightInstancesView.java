package Views;

import DAO.Domain.FlightInstance;
import com.yammer.dropwizard.views.View;

import java.util.List;

/**
 * Created by priyadarshini on 3/27/15.
 */
public class FlightInstancesView extends View {
    private final List<FlightInstance> flightInstances;

    private final String url;

    public FlightInstancesView(List<FlightInstance> flightInstances, String url) {
        super("FlightInstanceQuery.mustache");
        this.flightInstances = flightInstances;
        this.url=url;
    }

    public List<FlightInstance> getFlightInstances() {
        return flightInstances;
    }

    public String getUrl() {
        return url;
    }
}
