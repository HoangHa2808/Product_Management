package model;

public class CustomerEditting {

    private String lastName, firstName;

    public CustomerEditting() {
    }

    public CustomerEditting(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
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

     @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
