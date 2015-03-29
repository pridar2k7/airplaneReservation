package Mapper;

import DAO.Domain.FlightInstance;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class FlightInstanceDetailsMapper implements ResultSetMapper<FlightInstance> {
    @Override
    public FlightInstance map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new FlightInstance(resultSet.getString("flight_number"), resultSet.getString("flight_date"));
    }
}
