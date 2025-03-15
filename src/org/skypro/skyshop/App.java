package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.*;

public class App {
    public static void main(String[] args) {
        try {
            ProductBasket basket = new ProductBasket();

            //Демонстрация классов
            //Добавление продукта в корзину.
            basket.addToBasket(new SimpleProduct("egg", 100));
            basket.addToBasket(new SimpleProduct("milk", 80));
            basket.addToBasket(new DiscountedProduct("cookie", 150, 10));
            basket.addToBasket(new SimpleProduct("milk", 80));
            basket.addToBasket(new DiscountedProduct("cookie", 150, 10));


            //печать текущей корзины
            basket.printProductsOfBasket();

            //удаление всех Product объектов где встречается "milk" и печать удаленных объектов
            System.out.println(basket.removeFromBasketByName("milk"));

            //печать текущей корзины
            basket.printProductsOfBasket();

            //удаление всех Product объектов с несуществующим в корзине продукта
            System.out.println(basket.removeFromBasketByName("chicken"));

            //печать текущей корзины
            basket.printProductsOfBasket();


            SearchEngine searchEngine = new SearchEngine();

            searchEngine.add(new SimpleProduct("milk", 80));
            searchEngine.add(new DiscountedProduct("cookie", 150, 10));
            searchEngine.add(new FixPriceProduct("vegetable cutter"));
            searchEngine.add(new SimpleProduct("sugar", 60));
            searchEngine.add(new SimpleProduct("egg", 100));



            searchEngine.add(new Article("Ночник",
                    "Ночник для новорожденных с генератором белого шума"));
            searchEngine.add(new Article("Видеоняня",
                    "Видеоняня с монитором, беспроводная 1280 * 720 HD"));

            Set<Searchable> result1 = searchEngine.search("u");

            System.out.println(result1);

            Searchable result2 = searchEngine.search2("coo");

            System.out.println(result2);


        } catch (IllegalArgumentException e) {
            System.out.println("Введены не корректные данные!");
        }

    }
}