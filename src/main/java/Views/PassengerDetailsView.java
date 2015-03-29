package Views;

/**
 * Created by priyadarshini on 3/26/15.
 */

import DAO.Domain.Customer;
import com.yammer.dropwizard.views.View;

import java.util.List;


public class PassengerDetailsView extends View{
    private final List<Customer> customerList;

    public PassengerDetailsView(List<Customer> customerList) {
        super("PassengerDetails.mustache");
        this.customerList = customerList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
