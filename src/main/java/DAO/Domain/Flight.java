package DAO.Domain;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class Flight {
    String flightNumber;
    String weekdays;
//    String firstConnectingFlight;
//    String firstConnectingWeekday;
//    String secondConnectingFlight;
//    String secondConnectingWeekday;

    public Flight(String flightNumber, String weekdays) {
        this.flightNumber = flightNumber;
        this.weekdays = weekdays;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(String weekdays) {
        this.weekdays = weekdays;
    }
}
