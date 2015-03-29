package DAO.Domain;

/**
 * Created by priyadarshini on 3/27/15.
 */
public class FlightInstance {
    String flightNumber;
    String flightDate;

    public FlightInstance(String flightNumber, String flightDate) {
        this.flightDate=flightDate;
        this.flightNumber=flightNumber;
    }


    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

}
