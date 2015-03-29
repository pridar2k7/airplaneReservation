package DAO.Domain;

/**
 * Created by priyadarshini on 3/27/15.
 */
public class Customer {
    String name;
    String phoneNumber;

    public Customer(String customerName, String customerPhone) {
        this.name=customerName;
        this.phoneNumber=customerPhone;
    }

    public Customer(String customerName) {
        this.name=customerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
