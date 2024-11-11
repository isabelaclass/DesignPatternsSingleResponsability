package singleresponsability;

import java.util.ArrayList;
import java.util.List;

public class Purch {

    List<Product> purch_products = new ArrayList<Product>();

    public void addPurchProduct(Product product) {
        purch_products.add(product);
    }


}
