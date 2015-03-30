package Mapper;

import DAO.Domain.Flight;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class FlightDetailsMapper implements ResultSetMapper<Flight> {
    @Override
    public Flight map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Flight firstFlight = new Flight(asList(resultSet.getString("flight_number")), asList(resultSet.getString("weekdays").split("_")));
        return firstFlight;
    }
}
