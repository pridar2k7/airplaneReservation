package DAO.Mapper;


import DAO.Fare;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by priyadarshini on 3/9/15.
 */
public class FlightFareMapper implements ResultSetMapper<Fare> {

    public Fare map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Fare(r.getString("flight_number"),r.getString("fare_code"), r.getString("amount"), r.getString("restrictions"));
    }
}
