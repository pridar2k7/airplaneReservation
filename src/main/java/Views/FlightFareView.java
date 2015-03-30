package Views;

/**
 * Created by priyadarshini on 3/26/15.
 */

import DAO.Domain.Fare;
import com.yammer.dropwizard.views.View;

import java.util.List;


public class FlightFareView extends View{
    private final List<Fare> fareDetails;

    public FlightFareView(List<Fare> fareDetails) {
        super("FlightFare.mustache");
        this.fareDetails = fareDetails;
    }

    public List<Fare> getFareDetails() {
        return fareDetails;
    }
}
