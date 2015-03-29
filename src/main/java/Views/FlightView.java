package Views;

/**
 * Created by priyadarshini on 3/26/15.
 */

import DAO.Domain.Fare;
import com.yammer.dropwizard.views.View;

import java.util.List;


public class FlightView extends View{
    private final List<Fare> fareDetails;

    public FlightView(List<Fare> fareDetails) {
        super("Flight.mustache");
        this.fareDetails = fareDetails;
    }

    public List<Fare> getFareDetails() {
        return fareDetails;
    }
}
