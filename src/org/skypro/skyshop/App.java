package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exeption.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.lang.reflect.Array;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        String query = "cufdt";
        try {
            ProductBasket basket = new ProductBasket();

            //Демонстрация классов
            //Добавление продукта в корзину.
            basket.addToBasket(new SimpleProduct("egg", 100));

            //Заполнение корзины
            basket.addToBasket(new SimpleProduct("milk", 80));
            basket.addToBasket(new DiscountedProduct("cookie", 150, 10));
            basket.addToBasket(new FixPriceProduct("vegetable cutter"));
            basket.addToBasket(new SimpleProduct("sugar", 60));

            SearchEngine searchEngine = new SearchEngine(10);

            searchEngine.add(new SimpleProduct("milk", 80));
            searchEngine.add(new DiscountedProduct("cookie", 150, 10));
            searchEngine.add(new FixPriceProduct("vegetable cutter"));
            searchEngine.add(new SimpleProduct("sugar", 60));
            searchEngine.add(new SimpleProduct("egg", 100));


            searchEngine.add(new Article("Ночник",
                    "Ночник для новорожденных с генератором белого шума"));
            searchEngine.add(new Article("Видеоняня",
                    "Видеоняня с монитором, беспроводная 1280 * 720 HD"));

            Searchable result = searchEngine.search2("coo");

            System.out.println(result);


        } catch (IllegalArgumentException e) {
            System.out.println("Введены не корректные данные!");
        }


    }
}