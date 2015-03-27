/**
 * Created by priyadarshini on 2/13/15.
 */

import DAO.FlightDAO;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;
import config.AirlineReservationServiceConfiguration;
import com.yammer.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;
import resource.FlightResource;


public class AirlineReservationService extends Service<AirlineReservationServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new AirlineReservationService().run(args);
    }

    @Override
    public void initialize(final Bootstrap<AirlineReservationServiceConfiguration> bootstrap) {
        bootstrap.setName("airline-reservation");
        bootstrap.addBundle(new ViewBundle());
    }


    // Create a DBI factory and build a JDBI instance final DBIFactory factory = new DBIFactory();
    // final DBI jdbi = factory .build(e, c.getDataSourceFactory(), "mysql");
    // Add the resource to the environment e.jersey().register(new ContactResource(jdbi)); }
    @Override
    public void run(AirlineReservationServiceConfiguration conf, Environment env) throws Exception {
        final DBIFactory factory = new DBIFactory();
        DBI jdbi = factory.build(env, conf.getDataBase(), "mysql");
        FlightDAO flightDAO = jdbi.onDemand(FlightDAO.class);
        env.addResource(new FlightResource(conf.getMessages(), flightDAO));
    }


}
