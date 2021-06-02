package sort;

import compare.Comparator;
import data.Student;
import lists.Listable;

import java.util.List;

public interface Sortable<T>{
    void sort(Listable<Student> list, Comparator<Student> comp, int begin, int end);
}
