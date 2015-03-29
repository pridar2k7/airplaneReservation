package Mapper;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class AirportCodeMapper implements ResultSetMapper<String> {
    @Override
    public String map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return resultSet.getString("airport_code");
    }
}
