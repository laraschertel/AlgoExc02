package sort;

import compare.Comparator;
import data.Student;
import lists.Listable;

public class QuickSort<T> extends Swap<Student> implements Sortable<Student> {
    @Override
    public void sort(Listable<Student> list, Comparator<Student> comp, int begin, int end) {
        int i = begin;
        int j = end;
        Student pivot = list.get(end);

        while (i <= j) {
            while (comp.compare(list.get(i), pivot) < 0) {
                i++;
            }

            while (comp.compare(list.get(j), pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(list, i, j);
                i++;
                j--;
            }
        }
        if (begin < j) {
            sort(list, comp, begin, j);
        }
        if (end > i) {
            sort(list, comp, i, end);
        }
    }

}





