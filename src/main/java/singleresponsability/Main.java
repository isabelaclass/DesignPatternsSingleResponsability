package singleresponsability;

public class Main {

    public static void main(String[] args) {

        Product product_one = new Product(1, "rice", 3.45, 5);
        Product product_two = new Product(2, "pen", 0.45, 15);

        Inventory inventory = new Inventory();

        inventory.addNewProduct(product_one);
        inventory.addNewProduct(product_two);

        System.out.println("Inventory dateils: ");
    }
}
