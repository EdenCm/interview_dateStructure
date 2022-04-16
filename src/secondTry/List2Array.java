package secondTry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class List2Array  {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer [] array = new Integer[list.size()];
        list.toArray(array);
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
    }
}
