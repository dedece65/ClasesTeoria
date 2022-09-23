package tiposDeProblemas;


/*TIPOS DE PROBLEMAS
* 1) Codigo funcional -> Solucion Iterativa -> Recursiva Final
* 2) Definicion -> Recursiva No Final -> Recursiva Final -> Iterativa -> Funcional
* 3) Definicion Recursiva Multiple ->
*       -> Recursiva Sin Memoria
*       -> Recursiva Con Memoria
*       -> Iterativa
* */

import java.util.*;
import java.util.stream.IntStream;

public class EjemplosIterativoRecursivo {
    public static void main(String[] args) {
        Set<Integer> s1 = Set.of(1, 2, 3, 4);
        Set<Integer> s2 = Set.of(5, 6, 7, 8);
        Set<Integer> s3 = Set.of(9, 10, 11, 12);
        List<Set<Integer>> lista = List.of(s1, s2, s3);
//        System.out.println("sumaNumIterativo: "+sumaNumIterativo(lista));
//        System.out.println("sumaNumRecursivo: "+sumaNumRecursivo(lista));
//        System.out.println(sumaCuadradosFuncional(2, 4));
//        System.out.println(sumaCuadradosIterativo(2, 4));
//        System.out.println(sumaCuadradosRecursivo(2, 4));
//        System.out.println(sumaMultiplosFuncional(2, 10, 2));
//        System.out.println(sumaMultiplosIterativo(2, 10, 2));
//        System.out.println(sumaMultiplosRecursivo(2, 10, 2));
        System.out.println(sumaElemsFuncional(lista));
        System.out.println(sumaElemsIterativo(lista));
        System.out.println(sumaElemsRecursivo(lista));
    }

    public static Integer sumaNumIterativo(List<Integer> ls) {
        int e = 0;
        Integer b = 0;
        while (e < ls.size()) {
            b += ls.get(e);
            e = e + 1;
        }
        return b;
    }

    public static Integer sumaNumRecursivo(List<Integer> ls) {
        Integer e = 0;
        Integer b = 0;
        b = sumaNumRecursivo(e, b, ls);
        return b;
    }

    private static Integer sumaNumRecursivo(Integer e, Integer b, List<Integer> ls) {
        if (e < ls.size()) {
            b = sumaNumRecursivo(e + 1, b + ls.get(e), ls);
        }
        return b;
    }

    public static Double sumaCuadradosFuncional(Integer a, Integer b) {
        return IntStream.range(a, b).mapToDouble(e -> e * e).sum();
    }

    public static Double sumaCuadradosIterativo(Integer a, Integer b) {
        Integer e = a;
        double ac = 0.;
        while (e < b) {
            ac = ac + e * e;
            e = e + 1;
        }
        return ac;
    }

    public static Double sumaCuadradosRecursivo(Integer a, Integer b) {
        Integer e = a;
        double ac = 0.;
        ac = sumaCuadradosRecursivo(e, ac, a, b);
        return ac;
    }

    private static Double sumaCuadradosRecursivo(Integer e, Double ac, Integer a, Integer b) {
        if (e < b) {
            ac = sumaCuadradosRecursivo(e + 1, ac + e * e, a, b);
        }
        return ac;
    }

    public static Integer sumaMultiplosFuncional(Integer a, Integer b, Integer m) {
        return IntStream.range(a, b).filter(e -> e % m == 0).sum();
    }

    public static Integer sumaMultiplosIterativo(Integer a, Integer b, Integer m) {
        Integer e = a;
        int ac = 0;
        while (e < b) {
            if (e % m == 0) {
                ac = ac + e;
            }
            e = e + 1;
        }
        return ac;
    }

    public static Integer sumaMultiplosRecursivo(Integer a, Integer b, Integer m) {
        Integer e = a;
        int ac = 0;
        ac = sumaMultiplosRecursivo(e, ac, a, b, m);
        return ac;
    }

    private static Integer sumaMultiplosRecursivo(Integer e, Integer ac, Integer a, Integer b, Integer m) {
        if (e < b) {
            if (e % m == 0) {
                ac = sumaMultiplosRecursivo(e + 1, ac + e, a, b, m);
            } else {
                ac = sumaMultiplosRecursivo(e + 1, ac, a, b, m);
            }
        }
        return ac;
    }

    public static Integer sumaElemsFuncional(List<Set<Integer>> ls) {
        return ls.stream().flatMap(Collection::stream).mapToInt(Integer::intValue).sum();
    }

    public static Integer sumaElemsIterativo(List<Set<Integer>> ls) {
        int ac = 0;
        int i = 0;
        while (i < ls.size()) {
            for (Integer e : ls.get(i)) {
                ac = ac + e;
            }
            i = i + 1;
        }
        return ac;
    }

    public static Integer sumaElemsRecursivo(List<Set<Integer>> ls) {
        int i = 0;
        int ac = 0;
        ac = sumaElemsRecursivo(i, ac, ls);
        return ac;
    }

    private static Integer sumaElemsRecursivo(Integer i, Integer ac, List<Set<Integer>> ls) {
        if (i < ls.size()) {
            ac = sumaElemsRecursivo(i + 1, ac + sumaElemsGitanada(ls, i), ls);
        }
        return ac;
    }

    public static Integer sumaElemsGitanada(List<Set<Integer>> ls, Integer i) {
        return ls.get(i).stream().mapToInt(e -> e).sum();
    }
}