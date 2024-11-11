package singleresponsability;

import java.util.List;

public class InvetoryProducts {

    private List inventoryProducts;

    public Product searchProductByCode(List<Product> inventory_products, int code) {

        for (Product product : inventory_products) {
            if (product.getCode() == code) {
                return product;
            }
        }
        return null;
    }
}
