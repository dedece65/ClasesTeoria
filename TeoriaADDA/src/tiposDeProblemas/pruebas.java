package tiposDeProblemas;

import java.util.Iterator;
import java.util.Set;

public class pruebas {
    public static void main(String[] args) {
        Set<Integer> s1 = Set.of(1, 2, 3, 4);
        Iterator<Integer> it1 = s1.iterator();
        Integer ac = 0;
        while (it1.hasNext()) {
            Integer e = it1.next();
            System.out.println(e + " + " + ac);
            ac = ac + e;
        }
        System.out.println(ac);
    }
}