package compare;

public interface Comparator<T> {
    int compare(T o1, T o2);
    //return = 0 -> element sind gleich
    ///return = 1 -> nach oben sortiert
    // return = -1 -> nach unten sortiert
}
