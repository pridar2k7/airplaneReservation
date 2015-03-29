package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@SuppressWarnings("UnusedDeclaration")
public class AirlineReservationServiceConfiguration extends Configuration {

    @JsonProperty
    private DatabaseConfiguration dataBase = new DatabaseConfiguration();

    public DatabaseConfiguration getDataBase(){
        return dataBase;
    }
}
