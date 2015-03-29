package Views;

import com.yammer.dropwizard.views.View;

import java.util.List;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class AvailableSeatsView extends View{
    private final List<Integer> availableSeats;

    public AvailableSeatsView(List<Integer> availableSeats) {
        super("AvailableSeatsDetails.mustache");
        this.availableSeats = availableSeats;
    }

    public List<Integer> getAvailableSeats() {
        return availableSeats;
    }
}
