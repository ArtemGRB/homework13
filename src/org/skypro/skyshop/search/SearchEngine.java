package org.skypro.skyshop.search;

import org.skypro.skyshop.exeption.BestResultNotFound;

public class SearchEngine {

    private Searchable[] searchables;
    private int currentIndex = 0;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable searchable) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex] = searchable;
            currentIndex++;
        } else {
            System.out.println("Массив заполнен");
        }
    }


    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;


        for (Searchable searchable : searchables) {

            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results[count] = searchable; // Добавляем в результаты
                count++;

                if (count == 5) {
                    break;
                }
            }
        }

        return results;
    }

    public Searchable search2(String substring) throws BestResultNotFound {
        int count = 0;
        Searchable result = null;
        for (Searchable a : searchables) {
            if (a != null) {
                String str = a.getSearchTerm();
                int quantity = 0;
                int index = 0;
                int indexString = str.indexOf(substring, index);

                while (indexString != -1) {
                    quantity++;
                    index = indexString + substring.length();
                    indexString = str.indexOf(substring, index);
                }
                if (quantity > count) {
                    count = quantity;
                    result = a;
                }
            }
        }

        if (result == null) {
            throw new BestResultNotFound(substring);
        }
        return result;
    }
}
