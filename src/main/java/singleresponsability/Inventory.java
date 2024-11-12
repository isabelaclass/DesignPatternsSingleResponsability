package singleresponsability;

import database.SQLiteData;

public class Inventory {

    private SQLiteData sqliteData;

    public Inventory(SQLiteData sqliteData) {
        this.sqliteData = sqliteData;
    }

    public void addNewProduct(Product product) {
        sqliteData.insertProduct(product.getCode(), product.getName(), product.getPrice(), product.getQuantity());
        System.out.println("Product added to inventory: " + product.getName());
    }
}
