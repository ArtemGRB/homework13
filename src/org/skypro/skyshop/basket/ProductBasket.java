package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> productBasket = new ArrayList<>();

    //Добавление товара в корзину
    public void addToBasket(Product product) {
        productBasket.add(product);
    }

    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int getSumOfProducts() {
        int sum = 0;
        for (int i = 0; i < productBasket.size(); i++) {
            if (productBasket.get(i) != null) {
                sum += productBasket.get(i).getPrice();
            }
        }
        return sum;
    }

    //Метод печатает содержимое корзины
    public void printProductsOfBasket() {
        for (int i = 0; i < productBasket.size(); i++) {
            if (productBasket.get(i) != null) {
                System.out.println(productBasket.get(i));
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
        for (int i = 0; i < productBasket.size(); i++) {
            if (productBasket.get(i).getName().equals(nameOfProduct)) {
                return true;
            }
        }
        return false;
    }

    //Очистка корзины
    public void cleanBasket() {
        for (int i = 0; i < productBasket.size(); i++) {
            productBasket.remove(i);
        }
    }

    //подсчет количество специальных товаров
    public int getCountSpecialProduct() {
        int count = 0;
        for (int i = 0; i < productBasket.size(); i++) {
            if (productBasket.get(i) != null && productBasket.get(i).isSpecial()) {
                count++;
            }
        }
        return count;
    }

    //удаления продукта по имени из корзины
    public List<Product> removeFromBasketByName(String name) {
        List<Product> result = new ArrayList<>();
        Iterator<Product> iterator = productBasket.iterator();

        while (iterator.hasNext()) {
            Product element = iterator.next();
            if(element.getName().equals(name)){
                result.add(element);
                iterator.remove();
            }
        }
        return result;
    }

}
