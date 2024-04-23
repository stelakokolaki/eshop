package scytalys.models.product;

import lombok.Data;
import scytalys.models.product.ProductCategory;

//Το Data annotation εμπειριέχει setters , getters, constructor , toString
@Data

public class Product {
    private int id;
    private String name;
    private double price;
    private ProductCategory category;
    private String description="";
    private int quantity;
}
