package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@SuppressWarnings("UnusedDeclaration")
public class AirlineReservationServiceConfiguration extends Configuration {

    @NotNull
    @Valid
    private MessagesConfiguration messages;

    @JsonProperty
    private DatabaseConfiguration dataBase = new DatabaseConfiguration();

    public MessagesConfiguration getMessages() {
        return messages;
    }

    public void setMessages(MessagesConfiguration messages) {
        this.messages = messages;
    }

    public DatabaseConfiguration getDataBase(){
        return dataBase;
    }
}
