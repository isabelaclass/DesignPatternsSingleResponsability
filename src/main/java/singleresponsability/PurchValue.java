package singleresponsability;

import java.util.List;

public class PurchValue {
    public float calculatePurchValue(List<Product> purch_products) {

        float totalPurchValue = 0.00F;

        for(Product product : purch_products) {
            totalPurchValue += product.price;
        }

        return totalPurchValue;
    }
}
