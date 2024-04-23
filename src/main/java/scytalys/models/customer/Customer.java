package scytalys.models.customer;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private LocalDate registrationDate;
    private CustomerCategory category;
    private double balance;
}
