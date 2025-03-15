package org.skypro.skyshop.search;

import org.skypro.skyshop.exeption.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> searchables = new HashSet<>();


    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    // поиск в Searchable объектах по строке
    public Set<Searchable> search(String query) {

        Set<Searchable> searchableSet = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable o1, Searchable o2) {

                if (o1.getName().length() - o2.getName().length() == 0) {
                    return  o1.getName().compareTo(o2.getName());
                }

                return o1.getName().length() - o2.getName().length();
            }
        });

        for (Searchable searchable : searchables) {

            if (searchable.getSearchTerm().contains(query)) {

                searchableSet.add(searchable); // Добавляем в результаты
            }
        }
        return searchableSet;
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
