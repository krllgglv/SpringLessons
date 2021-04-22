package ru.kgogolev.Hometask1.goods;

import java.util.Random;

public final class ProductUtil {
    private ProductUtil(){

    }

    public static String itemsList(int quantity){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("<h3>");
        for (int i = 1; i < quantity+1; i++) {
            sb.append(i+". ");
            sb.append(new Product(
                    "name"+rand.nextInt(100),
                    rand.nextInt(1000),
                    1.0 * rand.nextInt(1000)
                    )
            );
            sb.append("<br>");
        }
        sb.append("<h3>");
        return sb.toString();
    }
    public static String defaultItemsList(){
        return itemsList(10);
    }
}
