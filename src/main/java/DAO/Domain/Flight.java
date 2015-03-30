package DAO.Domain;

import java.util.List;

/**
 * Created by priyadarshini on 3/28/15.
 */
public class Flight {
    List flightNumbers;
    List weekdays;
//    String firstConnectingFlight;
//    String firstConnectingWeekday;
//    String secondConnectingFlight;
//    String secondConnectingWeekday;

    public Flight(List flightNumber, List weekdays) {
        this.flightNumbers = flightNumber;
        this.weekdays = weekdays;
    }

    public List getFlightNumbers() {
        return flightNumbers;
    }

    public void setFlightNumbers(List flightNumbers) {
        this.flightNumbers = flightNumbers;
    }

    public List getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(List weekdays) {
        this.weekdays = weekdays;
    }
}
