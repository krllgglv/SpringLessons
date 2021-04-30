package ru.spring.context.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.context.cart.Cart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class ConsoleReader {

    private Cart cart;

    @Autowired
    public ConsoleReader(Cart cart) {
        this.cart = cart;
    }

    public void start() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while (!(line = br.readLine()).equals("exit")) {
                if (line.startsWith("add")) {
                    if (line.split(" ").length == 4) {
                        cart.addItem(line.split(""));
                    } else {
                        System.out.println(" wrong parametres");
                    }
                } else if (line.startsWith("remove")) {
                    if (line.split(" ").length == 2) {
                        cart.removeItem(Integer.parseInt(line.split(" ")[1]));
                    } else if (line.split(" ").length == 4) {
                        cart.removeItem(line.split(" "));
                    } else {
                        System.out.println(" wrong parametres for command remove");
                    }
                } else if (line.startsWith("show")) {
                    System.out.println(cart.getproductList());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
