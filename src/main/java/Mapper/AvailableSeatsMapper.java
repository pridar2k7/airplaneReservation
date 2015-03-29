package Mapper;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class AvailableSeatsMapper implements ResultSetMapper<Integer> {

    @Override
    public Integer map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return Integer.parseInt(resultSet.getString("available_seats"));
    }
}
