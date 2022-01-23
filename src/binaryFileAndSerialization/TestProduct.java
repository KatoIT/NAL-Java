package binaryFileAndSerialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestProduct {
    private List<Product> products;
    private final String PATH_FILE = "product.txt";

    public TestProduct() {
        this.products = new ArrayList<>();
    }

    public void insert(Product product) {
        products.add(product);
        writeToFile();
    }

    public Product find(int id) {
        readDataFromFile();
        for (Product product :
                products) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public void display() {
        readDataFromFile();
        for (Product product :
                products) {
            System.out.println(product);
        }
    }

    public void writeToFile() {
        try (FileOutputStream fos = new FileOutputStream(PATH_FILE);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataFromFile() {
        try (FileInputStream fis = new FileInputStream(PATH_FILE);
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            products = (List<Product>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
