package DAO;

import DAO.Domain.Customer;
import DAO.Domain.Fare;
import DAO.Domain.Flight;
import DAO.Domain.FlightInstance;
import Mapper.*;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.util.IntegerMapper;
import org.skife.jdbi.v2.util.StringMapper;

import java.util.List;

/**
 * Created by priyadarshini on 3/9/15.
 */

public interface FlightDAO {

    @Mapper(FlightFareMapper.class)
    @SqlQuery("select * from fare where flight_number =:flightNumber")
    List<Fare> getFareDetails(@Bind("flightNumber") String flightNumber);


    @Mapper(StringMapper.class)
    @SqlQuery("select distinct(flight_number) from fare")
    List<String> getFlightNumbers();


    @Mapper(FlightInstanceMapper.class)
    @SqlQuery("select flight_number, flight_date from flight_instance")
    List<FlightInstance> getFlightInstances();

    @Mapper(CustomerDetailsMapper.class)
    @SqlQuery("select customer_name, customer_phone from seat_reservation where flight_number =:flightNumber and flight_date=:flightDate")
    List<Customer> getCustomerDetails(@Bind("flightNumber") String flightNumber, @Bind("flightDate") String flightDate);


    @Mapper(CustomerNameMapper.class)
    @SqlQuery("select distinct(customer_name) from seat_reservation")
    List<Customer> getCustomerNames();

    @Mapper(FlightInstanceMapper.class)
    @SqlQuery("select flight_number, flight_date from seat_reservation where customer_name=:name")
    List<FlightInstance> getFlightInstanceDetails(@Bind("name") String name);

    @Mapper(IntegerMapper.class)
    @SqlQuery("select available_seats from flight_instance where flight_number=:flightNumber and flight_date=:flightDate")
    List<Integer> getAvailableSeats(@Bind("flightNumber") String flightNumber,@Bind("flightDate") String flightDate);

    @Mapper(StringMapper.class)
    @SqlQuery("select distinct(airport_code) from airport;")
    List<String> getAirportCodes();

    @Mapper(FlightDetailsMapper.class)
    @SqlQuery("select flight_number, weekdays from flight where departure_airport_code=:fromAirportCode and arrival_airport_code=:toAirportCode")
    List<Flight> getDirectFlights(@Bind("fromAirportCode") String fromAirportCode, @Bind("toAirportCode") String toAirportCode);

    @Mapper(FlightDetailsMapper.class)
    @SqlQuery("select *, SUBTIME(f1.scheduled_departure_time, f.scheduled_arrival_time) from " +
            "flight f JOIN flight f1 ON f.arrival_airport_code=f1.departure_airport_code " +
            "where f.departure_airport_code =:fromAirportCode and " +
            "f1.arrival_airport_code =:toAirportCode and " +
            "SUBTIME(f1.scheduled_departure_time, f.scheduled_arrival_time)> '01:00:00' and " +
            "(replace(concat('_',concat(f.weekdays,'_')), '_','.*') REGEXP replace(concat('_',concat(f1.weekdays,'_')), '_','.*') or " +
            "replace(concat('_',concat(f1.weekdays,'_')), '_','.*') REGEXP replace(concat('_',concat(f.weekdays,'_')), '_','.*'))")
    List<Flight> getFlightsWithOneLeg(@Bind("fromAirportCode") String fromAirportCode, @Bind("toAirportCode") String toAirportCode);
}
