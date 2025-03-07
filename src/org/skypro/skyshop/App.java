package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        //Демонстрация классов
        //Добавление продукта в корзину.
        basket.addToBasket(new SimpleProduct("egg", 100));

        //Заполнение корзины
        basket.addToBasket(new SimpleProduct("milk", 80));
        basket.addToBasket(new DiscountedProduct("cookie", 150, 10));
        basket.addToBasket(new FixPriceProduct("vegetable cutter"));
        basket.addToBasket(new SimpleProduct("sugar", 60));

        //Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addToBasket(new SimpleProduct("sugar", 60));

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