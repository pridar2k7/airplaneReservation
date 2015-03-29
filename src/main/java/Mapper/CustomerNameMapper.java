package Mapper;

import DAO.Domain.Customer;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by priyadarshini on 3/27/15.
 */
public class CustomerNameMapper implements ResultSetMapper<Customer> {
    @Override
    public Customer map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Customer(resultSet.getString("customer_name"));
    }
}
