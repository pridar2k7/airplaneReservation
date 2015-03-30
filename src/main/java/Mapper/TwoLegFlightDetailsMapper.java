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
public class TwoLegFlightDetailsMapper implements ResultSetMapper<Flight> {
    @Override
    public Flight map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Flight firstFlight = new Flight(asList(resultSet.getString("firstFNum"), resultSet.getString("secondFNum"), resultSet.getString("thirdFNum"))
                ,asList(resultSet.getString("firstWD"), resultSet.getString("secondWD"), resultSet.getString("thirdWD")));
        return firstFlight;
    }
}
