package model;

import com.raven.table.model.TableRowData;

public class Customer extends TableRowData{

    private String ID, lastName, firstName, phoneNumber, email, address;

    public Customer() {
    }

    public Customer(String ID, String lastName, String firstName, String phoneNumber, String email, String address) {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Object[] toTableRow() {
        return new Object[]{ID, lastName, firstName, phoneNumber, email, address};
    }
}
