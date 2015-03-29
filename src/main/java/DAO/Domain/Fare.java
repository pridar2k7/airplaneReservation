package DAO.Domain;

/**
 * Created by priyadarshini on 3/26/15.
 */
public class Fare {
    String flightNumber;
    String fareCode;
    String amount;
    String restrictions;

    public Fare(String flightNumber, String fareCode, String amount, String restrictions) {
        this.flightNumber = flightNumber;
        this.fareCode = fareCode;
        this.amount = amount;
        this.restrictions = restrictions;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFareCode() {
        return fareCode;
    }

    public String getAmount() {
        return amount;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setFareCode(String fareCode) {
        this.fareCode = fareCode;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }
}
