package search;

import compare.Comparator;
import lists.Listable;

public interface Searchable<T> {
    int search(Listable<T> list, Comparator<T> comp, T object);

}
