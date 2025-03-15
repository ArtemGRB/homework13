package org.skypro.skyshop.search;

import org.skypro.skyshop.exeption.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    private Map<String, Searchable> searchableMap = new TreeMap<>();
    private List<Searchable> searchables = new ArrayList<>();


    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    // поиск в Searchable объектах по строке
    public Map<String, Searchable> search(String query) {

        for (Searchable searchable : searchables) {

            if (searchable.getSearchTerm().contains(query)) {

                searchableMap.put(searchable.getName(),searchable); // Добавляем в результаты
            }
        }
        return searchableMap;
    }


    // поиск Searchable объекта в котором больше всего встречается поисковая строка
    public Searchable search2(String substring) {
        int count = 0;
        Searchable result = null;
        for (Searchable a : searchables) {

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

        if (result == null) {
            try {
                throw new BestResultNotFound(substring);
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
