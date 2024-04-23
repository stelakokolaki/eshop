package scytalys.eshopStreams;

import com.github.javafaker.Faker;
import scytalys.models.customer.Customer;
import scytalys.models.customer.CustomerCategory;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CustomerStreamRepository {
    private  List<Customer> customers = new ArrayList<Customer>();     //Creating a list object for my generated customers
    public CustomerCategory randomCategory(){ // Here is a Java generated Faker maker
        Faker faker = new Faker();
        int random = faker.number().numberBetween(0, CustomerCategory.values().length);
        return CustomerCategory.values()[random]; //Java weird syntax
    }
    public void fillListWithData(){
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) { //Declerate && Generate customer as a row of a table
            Customer customer = new Customer();
            customer.setId(i);
            customer.setFirstName(faker.name().firstName());
            customer.setLastName(faker.name().lastName());
            customer.setEmailAddress(faker.internet().emailAddress());
            customer.setRegistrationDate(faker.date().past(365, TimeUnit.DAYS).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
            customer.setCategory(randomCategory());
            customer.setBalance(faker.number().randomDouble(2, 1, 100));
            customers.add(customer); //Add every customer column to an array for our list
        }
    }

    public void printList(){
        customers.forEach(System.out::println);
    } //Print the customer list

    // -> Implement 7 analytic operations in a list Section
    //1.Sorting

    public void sortCustomerBalance(){
        customers = customers.stream()
                .sorted(Comparator.comparingDouble(customer -> customer.getBalance()))
                .collect(Collectors.toList());
    }
    //2.Filtering
    public List<Customer> getNameCustomerEnds(String ending){
        return customers = customers.stream()
                .filter(customer -> customer.getFirstName()!=null)
                .filter(customer -> customer.getFirstName().endsWith(ending))
                .collect(Collectors.toList());
    }

    //3.Mapping

    public List<String> getCustumer

    //4.Reducing    min, max, average, sum, count, stdev, concatenation

    //5.Matching

    //6.Counting

    //7.Grouping

}
