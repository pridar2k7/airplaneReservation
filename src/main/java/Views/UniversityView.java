package Views;

/**
 * Created by priyadarshini on 3/26/15.
 */

import DAO.Fare;
import com.yammer.dropwizard.views.View;

import java.util.List;


public class UniversityView extends View{
    private final List<Fare> fareDetails;

    public UniversityView(List<Fare> fareDetails) {
        super("University.mustache");
        this.fareDetails = fareDetails;
    }

    public List<Fare> getFareDetails() {
        return fareDetails;
    }
}
