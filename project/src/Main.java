import model.entity.Inventory;
import model.entity.Product;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        var inventory = new Inventory();
        var coca = "Coca-cola";

        inventory.add(new Product(coca, 30, 5));

        int total = 30;
        Random random = new Random();

        var threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {

            int change = random.nextInt(-50, 200);
            total += change;

            threads[i] = new Thread(() -> inventory.changeQuantity(coca, change));
        }

        for (var t : threads) {
            t.start();
        }


        for (var t : threads) {
            try {
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Quantidade final esperada: " + total);
        System.out.println(inventory.ListProducts());
    }
}
