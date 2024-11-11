package singleresponsability;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<Product> inventory_products = new ArrayList<Product>();

    public void addNewProduct(Product product) {
        inventory_products.add(product);
    }
}
