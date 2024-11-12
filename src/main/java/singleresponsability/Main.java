package singleresponsability;

import database.SQLiteData;

public class Main {

    public static void main(String[] args) {

        Product product_four = new Product(4, "Product D", 103.00, 10);

        SQLiteData sqliteData = new SQLiteData();

        Inventory inventory = new Inventory(sqliteData);
        InventoryProducts inventoryProducts = new InventoryProducts(sqliteData);

        if(!inventoryProducts.searchProductByCode(product_four.getCode()))
        {
            inventory.addNewProduct(product_four);
        }
        else
        {
            System.out.println("Product found: " + product_four.getName() + " - " + product_four.getPrice());
        }
    }
}
