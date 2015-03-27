package DAO;

import DAO.Mapper.FlightFareMapper;
import DAO.Mapper.FlightMapper;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * Created by priyadarshini on 3/9/15.
 */

public interface FlightDAO {

    @Mapper(FlightFareMapper.class)
    @SqlQuery("select * from fare where flight_number ='536'")
    List<Fare> getFareDetails();


    @Mapper(FlightMapper.class)
    @SqlQuery("select distinct(flight_number) from fare")
    List<String> getFlightNumbers();
}
