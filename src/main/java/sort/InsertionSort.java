package sort;

import compare.Comparator;
import data.Student;
import lists.Listable;

public class InsertionSort<T> extends Swap<Student> implements Sortable<Student>{
    @Override
    public void sort(Listable<Student> list, Comparator<Student> comp, int begin, int end) {
        for(int j = 1; j< list.size(); j++){
            int i = j-1;
            while((i > -1) && (comp.compare(list.get(i+1), list.get(i)) < 0)){
                swap(list, i, (i+1));
                i--;
            }
        }
    }
}
