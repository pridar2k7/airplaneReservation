package DAO;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * Created by priyadarshini on 3/9/15.
 */

public interface UniversityDAO {

    @Mapper(UniversityMapper.class)
    @SqlQuery("select * from fare where flight_number ='536'")
    List<Fare> getFareDetails();
}
