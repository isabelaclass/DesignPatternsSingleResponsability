package singleresponsability;

import java.util.List;

public class PurchDetails {

    PurchValue purchValue = new PurchValue();


    public void purchDetails(List<Product> purch_products) {
        System.out.println("Purch Details: ");

        for(Product product : purch_products) {
            System.out.println("Product:  " +  product.getName() + "Price: " + product.getPrice());
        }

        System.out.println("Total: " + purchValue.calculatePurchValue(purch_products));
    }
}
