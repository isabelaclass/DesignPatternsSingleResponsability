package singleresponsability;

public class Product {

    int     code;
    String  name;
    double   price;
    int     quantity;

    public Product(int code, String name, double price, int quantity) {
       this.code = code;
       this.name = name;
       this.price = price;
       this.quantity = quantity;
   }

   public double calculateTotalValue(double price, int quantity) {
       return price * quantity;
   }

    public int getCode() {
        return code;
    }

    public String getName() {
       return name;
   }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
