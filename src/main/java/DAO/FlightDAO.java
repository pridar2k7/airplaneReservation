package DAO;

import DAO.Mapper.FlightFareMapper;
import DAO.Mapper.FlightMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * Created by priyadarshini on 3/9/15.
 */

public interface FlightDAO {

    @Mapper(FlightFareMapper.class)
    @SqlQuery("select * from fare where flight_number =:flightNumber")
    List<Fare> getFareDetails(@Bind("flightNumber") String flightNumber);


    @Mapper(FlightMapper.class)
    @SqlQuery("select distinct(flight_number) from fare")
    List<String> getFlightNumbers();
}
