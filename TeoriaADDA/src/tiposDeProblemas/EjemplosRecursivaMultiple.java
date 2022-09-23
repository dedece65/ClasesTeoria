package tiposDeProblemas;

import java.util.Map;

import us.lsi.common.Map2;
import us.lsi.common.String2;

public class EjemplosRecursivaMultiple {
	//
	public static void main(String[] args) {
        Integer n = 100;
        String2.toConsole("El fibonacci de %d = %d", n, fibRCM(n));
    }

    /*
     * fib(n):
     *   u; u<=1
     * fib(n-1) + fib(n-2); en otro caso*/
	
    public static Long fibRSM(Integer n) {
        Long r = null;
        if (n <= 1) {
            r = (long)n;
        } else {
            r = fibRSM(n - 1) + fibRSM(n - 2);
        }
        return r;
    }
    public static Long fibRCM(Integer n) {
        return fibRCM(Map2.empty(), n);
    }
    private static Long fibRCM(Map<Integer, Long> m, Integer n) {
        //todas las recursivas con memoria van de la siguiente manera:
        Long r = m.get(n); //preguntar si el problema ya ha sido resuelto (si ya hay una clave en el map que tiene asociado un valor)
        if (r == null) {
            if (n <= 1) {
                r = (long)n;
            } else {
                r = fibRCM(m, n - 1) + fibRCM(m, n - 2);
                m.put(n, r);
            }
        }
        return r;
	}
}
