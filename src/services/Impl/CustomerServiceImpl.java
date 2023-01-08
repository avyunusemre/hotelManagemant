package services.Impl;

import entities.Customer;
import services.CustomerService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

    public Map<Long, Customer> customers = new HashMap<>();

    public CustomerServiceImpl() {
        Customer customer1 = new Customer(1L, "Yunus Emre", "Kaya", "312312445");
        Customer customer2 = new Customer(2L, "Hasan", "Mezarci", "3423526231");
        Customer customer3 = new Customer(3L, "Neval", "Yurt", "2134124342");
        Customer customer4 = new Customer(4L, "Ayse", "Yilmaz", "23432423");

        customers.put(customer1.getId(), customer1);
        customers.put(customer2.getId(), customer2);
        customers.put(customer3.getId(), customer3);
        customers.put(customer4.getId(), customer4);
    }

    @Override
    public Long addCustomer(Customer newCustomer) {
        customers.put(newCustomer.getId(), newCustomer);
        return newCustomer.getId();
    }

    @Override
    public void createOrUpdateReservation(Customer customer, LocalDateTime checkIn, LocalDateTime checkOut) {
        customer.setCheckIn(checkIn);
        customer.setCheckOut(checkOut);
    }

    @Override
    public double calculatePayment() {
        return 0;
    }


    @Override
    public Long deleteCustomer(Long deletedCustomerId) {
       customers.remove(deletedCustomerId);
       return deletedCustomerId;
    }

}
