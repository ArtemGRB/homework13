package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        //Демонстрация классов
        //Добавление продукта в корзину.
        basket.addToBasket(new Product("egg", 100));

        //Заполнение корзины
        basket.addToBasket(new Product("milk", 80));
        basket.addToBasket(new Product("cookie", 150));
        basket.addToBasket(new Product("salt", 10));
        basket.addToBasket(new Product("sugar", 60));

        //Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addToBasket(new Product("sugar", 60));

        //Печать содержимого корзины с несколькими товарами.
        basket.printProductsOfBasket();

        //Получение стоимости корзины с несколькими товарами.
        System.out.println(basket.getSumOfProducts());

        //Поиск товара, который есть в корзине.
        System.out.println(basket.checkProductInBasket("salt"));

        //Поиск товара, которого нет в корзине.
        System.out.println(basket.checkProductInBasket("carrot"));

        //Очистка корзины.
        basket.cleanBasket();

        //Печать содержимого пустой корзины.
        basket.printProductsOfBasket();

        //Получение стоимости пустой корзины.
        System.out.println(basket.getSumOfProducts());

        //Поиск товара по имени в пустой корзине.
        System.out.println(basket.checkProductInBasket("carrot"));

    }
}