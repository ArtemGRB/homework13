package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.sql.SQLOutput;
import java.util.*;

public class ProductBasket {

    private Map<String, List<Product>> productBasketMap = new HashMap<>();

    //Добавление товара в корзину
    public void addToBasket(Product product) {
        productBasketMap.computeIfAbsent(product.getName(), k -> new ArrayList<Product>()).add(product);
    }


    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int getSumOfProducts() {
        int sum = 0;
        for (List<Product> productList : productBasketMap.values()) {
            for (Product product : productList) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    //Метод печатает содержимое корзины
    public void printProductsOfBasket() {
        for (List<Product> productList : productBasketMap.values()) {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
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
        for (String k : productBasketMap.keySet()) {
            productBasketMap.remove(k);
        }
    }

    //подсчет количество специальных товаров
    public int getCountSpecialProduct() {
        int count = 0;
        for (List<Product> productList : productBasketMap.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    //удаления продукта по имени из корзины
    public List<Product> removeFromBasketByName(String name) {
        return productBasketMap.remove(name);
    }
}
