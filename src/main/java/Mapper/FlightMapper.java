package Mapper;


import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by priyadarshini on 3/9/15.
 */
public class FlightMapper implements ResultSetMapper<String> {

    public String map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return r.getString("flight_number");
    }
}
