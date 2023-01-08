package services;

import entities.Customer;

import java.time.LocalDateTime;

public interface CustomerService {
    public Long addCustomer(Customer newCustomer);
    public void createOrUpdateReservation(Customer customer, LocalDateTime checkIn, LocalDateTime checkOut);
    public double calculatePayment();

    public Long deleteCustomer(Long deletedCustomerId);
}
