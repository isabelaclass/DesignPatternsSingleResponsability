# Product Management System

This project implements a simple **Product Management System** for a store, following the **Single Responsibility Principle (SRP)**. Each class in the project is designed with a single well-defined responsibility, ensuring a modular and maintainable structure. This project uses **Java** and **SQLite** for data persistence, allowing basic operations such as adding products and purchases and retrieving purchase and product data from a database.

## Project Structure

The project consists of the following classes and responsibilities:

1. **Product**  
   Represents a product in the store, with attributes such as `id`, `name`, `price`, and `quantity`.  
   - `calculateTotalValue()`: Calculates the total value of the product in stock based on its price and quantity.

2. **Purch (Purchase)**  
   Represents a purchase transaction, containing a list of `PurchProduct` instances and the purchase date.
   - `addPurchProduct(Product product)`: Adds a product to the purchase list.
   
3. **PurchProduct**  
   Associates a specific `Purch` with the products purchased and the quantities of each product. This class contains `purchId`, `productId`, and `quantity`.

4. **ProductRepository**  
   Handles all database operations related to `Product`, such as adding and retrieving products.

5. **PurchRepository**  
   Handles database operations for `Purch`, including saving purchases to the database.

6. **PurchProductRepository**  
   Manages database operations that associate `Purch` with `Product`, enabling tracking of products within each purchase.

## Database Configuration

This project uses **SQLite** as the database, allowing for straightforward data management without an ORM (Object Relational Mapping). A `JDBC` connection is established to perform CRUD (Create, Read, Update, Delete) operations in SQLite.

- **Database Tables**:  
  - `product`: Stores product data (`id`, `name`, `price`, `quantity`).
  - `purch`: Stores purchase data (`id`, `date`).
  - `purch_product`: Links purchases to products, storing `purch_id`, `product_id`, and `quantity`.

## UML Class

## Example Usage

The main application connects to the database, then uses the repository classes to add, retrieve, and manipulate data in the database.

```java
// Creating a product and adding it to the database
ProductRepository productRepo = new ProductRepository();
Product product = new Product("Product A", 100.00, 20);
productRepo.addProduct(product);

// Creating a purchase and linking it with products
PurchRepository purchRepo = new PurchRepository();
Purch purch = new Purch("2024-11-10");
purch.addPurchProduct(product);
purchRepo.addPurch(purch);
