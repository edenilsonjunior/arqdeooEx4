import model.entity.Inventory;
import model.entity.Product;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String coca = "Coca-cola";
        int total = 30;

        Random random = new Random();
        var threads = new ArrayList<Thread>();

        var inventory = new Inventory();
        inventory.add(new Product(coca, 30, total));


        for (int i = 0; i < 10; i++) {

            int change = random.nextInt(-10, 200);
            total += change;

            var t = new Thread(() -> inventory.changeQuantity(coca, change));
            threads.add(t);
        }

        threads.forEach(t -> t.start());

        threads.forEach(t -> {
            try {
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("Quantidade final esperada: " + total);
        System.out.println(inventory.ListProducts());
    }
}
