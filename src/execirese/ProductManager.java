package execirese;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void insert(Product product) {
        products.add(product);
    }

    public boolean update(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public Product findByName(String productName) {
        for (Product product : products) {
            if (productName.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }

    public void sort(boolean reverse) {
        products.sort((o1, o2) -> {
            if (o1.getPrice() - o2.getPrice() < 0.00001) {
                return 0;
            } else {
                if (reverse) {
                    return (o1.getPrice() - o2.getPrice()) > 0 ? 1 : -1;
                } else {
                    return (o2.getPrice() - o1.getPrice()) > 0 ? 1 : -1;
                }

            }
        });
    }

    public void display() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
