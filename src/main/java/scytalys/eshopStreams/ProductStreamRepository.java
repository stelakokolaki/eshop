package scytalys.eshopStreams;

import com.github.javafaker.Faker;
import scytalys.models.product.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductStreamRepository {

    private final List<Product> products = new ArrayList<Product>();

    public void fillListWithData(){
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            // Generate fake data
            Product product = new Product();
            product.setId(i);
            product.setName(faker.commerce().productName());
            product.setPrice(faker.number().randomDouble(2, 1, 1000));
            product.setDescription(faker.lorem().sentence());
            product.setQuantity( faker.number().numberBetween(1, 5));
            products.add(product);
        }
    }

    public void printList(){
        products.forEach(System.out::println);
    }

    public void sortProducts() {
//        products =   products.stream()
//                .sorted(Comparator.comparingDouble(product -> product.getPrice()))
//                .collect(Collectors.toList());

        //creates new list , used when initial list is immutable
//        products =  products.stream()
//                .sorted(Comparator
//                        .comparingInt(Product::getQuantity)
//                        .thenComparing(Comparator.comparingDouble(Product::getPrice).reversed())
//                )
//                .collect(Collectors.toList());


   //mutates the list
        products.sort(Comparator
                .comparing(Product::getPrice).reversed()
                .thenComparing(Product::getName));

        //      Collections.sort(products, Comparator.comparingDouble(Product::getPrice));

    }
// 5 basic operation in a list
    // CRRUD

// -> 7 analytic operation in a list
    //Sorting
    //Filtering
    //Mapping
    //Reducing    min, max, average, sum, count, stdev, concatenation
    //Matching
    //Counting
    //Grouping

    public List<Product> getProductsAbovePriceLevel(double priceLevel) {
            return products.stream()
                    .filter(product -> product.getPrice() >priceLevel)
                    .collect(Collectors.toList());
    }

    public List<Product> getProductsStartsWith(String starting){
        return products.stream()
                .filter(product -> product.getName()!=null)
                .filter(product -> product.getName().startsWith(starting))
                .collect(Collectors.toList());
    }

public  List<String> getProductDescriptions() {
    return products.stream()
            .map( product -> product.getDescription())
            .collect(Collectors.toList());
    }

  public double getAveragePrice()  {
//      return products.stream()
//              .map(product -> product.getPrice())
//              .reduce(0.0, Double::sum)/ products.size();
//

      return products.stream()
              .mapToDouble(Product::getPrice)
              .average()
              .orElse(0);
  }

public long countProductsAbovePriceLevel(double priceLevel) {
    return products.stream()
            .filter(product -> product.getPrice() >priceLevel)
            .count();
 }

    public boolean existsProductWithName(String name) {
        return products.stream()
                .anyMatch(p -> p.getName().equals(name));
    }


    public Map <Integer, List<Product>>   createGroupsPerQuantity() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getQuantity));
    }
}


