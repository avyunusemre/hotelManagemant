package entities;

import java.time.LocalDateTime;

public class Customer extends AbstractEntity{
    private Long id;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Customer() {

    }

    public Customer(Long id, String firstName, String lastName, String mobilePhone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", mobilePhone = " + mobilePhone +
                ", checkIn = " + checkIn +
                ", checkOut = " + checkOut +
                '}';
    }

}
