package org.skypro.skyshop.search;

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
            if (searchable == null) {
                continue;
            }

            if (searchable.getSearchTerm().contains(query)) {
                results[count] = searchable; // Добавляем в результаты
                count++;

                if (count == 5) { break; }
            }
        }
        return results;
    }
}
