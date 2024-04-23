package scytalys.eshopStreams;
import scytalys.models.customer.Customer;
import scytalys.models.product.Product;

import java.util.List;
import java.util.Map;

public class FakeDataGenerator {

    public static void main(String[] args) {
        ProductStreamRepository productStreamRepository = new ProductStreamRepository();
        productStreamRepository.fillListWithData();

        CustomerStreamRepository customerStreamRepository = new CustomerStreamRepository();

        //PRODUCTS STREAM OPERATIONS Main class from ProductStreamRepository Class

//        //  productRepository.printList();
//        System.out.println("--------------------------------------");
//        productStreamRepository.sortProducts();
//        productStreamRepository.printList();
//
//        List<Product> products = productStreamRepository
//                .getProductsStartsWith("A");
//        products.forEach(System.out::println);
//
//
//        List<String> descriptionList = productStreamRepository.getProductDescriptions();
//        System.out.println("--------------------------------------");
//        descriptionList.forEach(System.out::println);
//
//        System.out.println("--------------------------------------");
//        System.out.println("products above 200 euros = "
//                + productStreamRepository.countProductsAbovePriceLevel(200));
//
//        System.out.println("--------------------------------------");
//        System.out.println("exist products with name Aerodynamic Steel Plate  = "
//                + productStreamRepository.existsProductWithName("Aerodynamic Steel Plate"));
//
//        Map<Integer, List<Product>> map = productStreamRepository.createGroupsPerQuantity();
//
//        map.forEach((quantity, group) -> {
//            System.out.println("***************************");
//            System.out.println("Quantity=" + quantity );
//            System.out.println("--------------------");
//            group.forEach(System.out::println);
//        });


        //CUSTOMERS STREAM OPERATIONS Main class from CustomerStreamRepository Class

        System.out.println(customerStreamRepository.randomCategory());
        customerStreamRepository.fillListWithData();
        customerStreamRepository.printList();
        // Customer(id=19, firstName=Florentina, lastName=Jaskolski, emailAddress=sau.turner@gmail.com, registrationDate=2023-08-04, category=GROSS, balance=30.92)

        System.out.println("-----------Sort---by----Balance--------------------");
        //Sorting
        customerStreamRepository.sortCustomerBalance();
        customerStreamRepository.printList();

        System.out.println("-----------Filter---customer's---First---Name---------------");
        //Filltering
        List<Customer> customer = customerStreamRepository
               .getNameCustomerEnds("a");
        customer.forEach(System.out::println);


        System.out.println("-----------Mapping-------------------------");
        //Mapping


        System.out.println("--------------Reducing------------------------------");
        //Reducing    min, max, average, sum, count, stdev, concatenation


        System.out.println("----------------Matching----------------------------");
        //Matching

        System.out.println("-------------------Counting-------------------------");
        //Counting

        System.out.println("------------------Grouping--------------------------");
        //Grouping




    }

}
