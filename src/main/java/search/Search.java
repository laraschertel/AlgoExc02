package search;

import compare.Comparator;
import lists.Listable;

public class Search<T> implements Searchable<T> {
    @Override
    public int search(Listable<T> list, Comparator<T> comp, T object) {
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            if (comp.compare(list.get(i), object) == 0) {
                System.out.println(list.get(i).toString());
                counter++;
            }
        }
            return counter;
        }

    }

