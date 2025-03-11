package org.skypro.skyshop.product;


import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String name;


    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
        }
    }


    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}
