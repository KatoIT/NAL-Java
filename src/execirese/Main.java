package execirese;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ProductManager manager = new ProductManager();
        Product product1 = new Product(0, "Iphone 1", 100.0);
        Product product2 = new Product(2, "Iphone 2", 200.0);
        Product product3 = new Product(3, "Iphone 3", 50.0);
        Product product4 = new Product(4, "Iphone 4", 170.0);
        manager.insert(product1);
        manager.insert(product2);
        manager.insert(product3);
        manager.insert(product4);
        System.out.println("List product: ");
        manager.display();
        manager.delete(3);
        System.out.println("List product after delete: ");
        manager.display();
        System.out.println("Find product name \"Iphone 2\": ");
        System.out.println(manager.findByName("Iphone 2"));


    }
}
