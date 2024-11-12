package singleresponsability;

import database.SQLiteData;

import java.sql.*;

public class InventoryProducts {

    private SQLiteData sqliteData;

    public InventoryProducts(SQLiteData sqliteData) {
        this.sqliteData = sqliteData;
    }

    public boolean searchProductByCode(int code) {
        String query = "SELECT * FROM product WHERE code = ?";
        Product product = null;

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:singlerepstore.db");
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, code);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int productCode = resultSet.getInt("code");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                product = new Product(productCode, name, price, quantity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (product != null) {
            return true;
            //System.out.println("Product found: " + product.getName() + " - " + product.getPrice());
        } else {
            return false;
            //System.out.println("Product not found!");
        }
    }
}
