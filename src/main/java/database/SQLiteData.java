package database;

import java.sql.*;

public class SQLiteData {

    private static final String URL = "jdbc:sqlite:singlerepstore.db";

    public void createTables() {
        String createProductTable = "CREATE TABLE IF NOT EXISTS product ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "code INTEGER NOT NULL, "
                + "name TEXT NOT NULL, "
                + "price REAL NOT NULL, "
                + "quantity INTEGER NOT NULL);";

        String createPurchTable = "CREATE TABLE IF NOT EXISTS purch ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "date TEXT NOT NULL);";

        String createPurchProductTable = "CREATE TABLE IF NOT EXISTS purch_product ("
                + "purch_id INTEGER NOT NULL, "
                + "product_id INTEGER NOT NULL, "
                + "quantity INTEGER NOT NULL, "
                + "PRIMARY KEY (purch_id, product_id), "
                + "FOREIGN KEY (purch_id) REFERENCES purch(id), "
                + "FOREIGN KEY (product_id) REFERENCES product(id));";

        try (Connection connection = DriverManager.getConnection(URL);
             Statement stmt = connection.createStatement()) {

            stmt.execute(createProductTable);
            stmt.execute(createPurchTable);
            stmt.execute(createPurchProductTable);

            System.out.println("Tables created with success!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProduct(int code, String name, double price, int quantity) {
        String insertProduct = "INSERT INTO product (code, name, price, quantity) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement stmt = connection.prepareStatement(insertProduct)) {

            stmt.setInt(1, code);
            stmt.setString(2, name);
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
            System.out.println("Product inserted with success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPurchase(String date) {
        String insertPurch = "INSERT INTO purch (date) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement stmt = connection.prepareStatement(insertPurch)) {

            stmt.setString(1, date);
            stmt.executeUpdate();
            System.out.println("Purch created with success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPurchaseProduct(int purchId, int productId, int quantity) {
        String insertPurchProduct = "INSERT INTO purch_product (purch_id, product_id, quantity) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement stmt = connection.prepareStatement(insertPurchProduct)) {

            stmt.setInt(1, purchId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
            System.out.println("Product inserted with success to yout purch!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
