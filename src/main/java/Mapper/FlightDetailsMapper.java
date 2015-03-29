package Mapper;

import DAO.Domain.Flight;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class FlightDetailsMapper implements ResultSetMapper<Flight> {
    @Override
    public Flight map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Flight(resultSet.getString("flight_number"), resultSet.getString("weekdays"));
    }
}
