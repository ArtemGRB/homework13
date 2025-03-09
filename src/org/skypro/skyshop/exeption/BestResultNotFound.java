package org.skypro.skyshop.exeption;

import java.io.IOException;

public class BestResultNotFound extends IOException {

    String query;

    public BestResultNotFound(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Совпадение с \"" + query + "\"не найдено";
    }
}
