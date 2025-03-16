package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;


public class ProductBasket {

    private Map<String, List<Product>> productBasketMap = new HashMap<>();

    //Добавление товара в корзину
    public void addToBasket(Product product) {
        productBasketMap.computeIfAbsent(product.getName(), k -> new ArrayList<Product>()).add(product);
    }

    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int getSumOfProducts() {

        return productBasketMap.values().stream().flatMap(Collection::stream).
                mapToInt(p -> p.getPrice()).sum();
    }

    //Метод печатает содержимое корзины
    public void printProductsOfBasket() {

        productBasketMap.values().stream().flatMap(Collection::stream).forEach(System.out::println);

        if (getSumOfProducts() != 0) {
            System.out.println("Итого: " + getSumOfProducts());

        } else {
            System.out.println("в корзине пусто");
        }
        System.out.println("Специальных товаров: " + getCountSpecialProduct());
    }

    //проверка наличия товара в корзине по названию
    public boolean checkProductInBasket(String nameOfProduct) {
        return productBasketMap.containsKey(nameOfProduct);
    }

    //Очистка корзины
    public void cleanBasket() {
        productBasketMap.clear();
    }

    //подсчет количество специальных товаров
    public int getCountSpecialProduct() {

        return (int) productBasketMap.values().stream().flatMap(Collection::stream)
                .filter(p -> p.isSpecial())
                .count();
    }

    //удаления продукта по имени из корзины
    public List<Product> removeFromBasketByName(String name) {
        return productBasketMap.remove(name);
    }
}
