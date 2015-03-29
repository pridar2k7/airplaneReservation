package Mapper;

import DAO.Domain.Flight;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class OneLegFlightDetailsMapper implements ResultSetMapper<List<Flight>> {
    @Override
    public List<Flight> map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Flight firstFlight = new Flight(resultSet.getString("firstFNum"), resultSet.getString("firstWD"));
        Flight secondFlight = new Flight(resultSet.getString("secondFNum"), resultSet.getString("secondWD"));
        return asList(firstFlight,secondFlight);
    }
}
