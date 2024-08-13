package model.entity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Inventory {

    private List<Product> products;

    public Inventory() {

        this.products = new CopyOnWriteArrayList<>();
    }

    public boolean add(Product product) {

        boolean exists = false;

        for (var p : this.products) {
            if (p.getName().equals(product.getName())) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            this.products.add(product);
            return true;
        }
        return this.products.add(product);

    }

    public void remove(Product product) {
        this.products.remove(product);
    }


    public String ListProducts() {
        String list = "";
        for (Product product : this.products) {
            list += product.toString() + "\n";
        }
        return list;
    }
}
