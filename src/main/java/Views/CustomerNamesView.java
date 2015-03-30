package Views;

import DAO.Domain.Customer;
import com.yammer.dropwizard.views.View;

import java.util.List;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class CustomerNamesView extends View{
    private List<Customer> customers;

    public CustomerNamesView(List<Customer> customers) {
        super("CustomerNamesQuery.mustache");
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
