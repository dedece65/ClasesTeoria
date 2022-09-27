package tiposDeProblemas;

import java.util.Map;

import us.lsi.common.IntPair;
import us.lsi.common.Map2;
import us.lsi.common.String2;

public class EjemplosRecursivaMultiple {
	//
	public static void main(String[] args) {
//		Integer n = 164;
//		String2.toConsole("El fibRCM de %d = %d", n, fibRCM(n));
//		String2.toConsole("El fibIterativo de %d = %d", n, fibIterativo(n));
		String2.toConsole("Rec.Sin Memoria: %d", fRSM(20, 20));
		String2.toConsole("Rec.Con Memoria: %d", ejercicio2RCM(20, 20));
		String2.toConsole("Rec.Con Memoria: %d", ejercicio2Iterativo(20, 20));
	}

	/*
	 * fib(n): 
	 * 	u; u<=1 
	 * 	fib(n-1) + fib(n-2); en otro caso
	 */

	public static Long fibRSM(Integer n) { // Es "equivalente" a la no final
		Long r = null;
		if (n <= 1) {
			r = (long) n;
		} else {
			r = fibRSM(n - 1) + fibRSM(n - 2);
		}
		return r;
	}
	
	public static Long fibRCM(Integer n) {
		return fibRCM(Map2.empty(), n);
	}

	private static Long fibRCM(Map<Integer, Long> mapa, Integer n) { // Es "equivalente" a la final
		// todas las recursivas con memoria van de la siguiente manera:
		Long r = mapa.get(n); // preguntar si el problema ya ha sido resuelto (si ya hay una clave en el map
								// que tiene asociado un valor)
		if (r == null) {
			if (n <= 1) {
				r = (long) n;
			} else {
				r = fibRCM(mapa, n - 1) + fibRCM(mapa, n - 2);
				mapa.put(n, r);
			}
		}
		return r;
	}

	public static Long fibIterativo(Integer n) {
		Long r = null;
		Map<Integer, Long> mp = Map2.empty();
		for (int i = 0; i <= n; i++) {
			if (i <= 1) {
				r = i + 0L;
			} else {
				r = mp.get(i - 1) + mp.get(i - 2);
			}
			mp.put(i, r);
		}
		return mp.get(n);
	}

	/*
	 * Sea la siguiente definicion: 
	 * f(a,b): 
	 * 	a + b; a <= 2 || b <= 2 
	 * 	f(a-2, b-3) + f(a/2, a/3) + a*b; en otro caso
	 */

	public static Long fRSM(Integer a, Integer b) {
		Long r = null;
		if(a<=2 || b<=2) {
			r= a + b + 0L;
		}else {
            r= a*b + fRSM(a-2, b-3) + fRSM(a/2, b/3);
        }
        return r;
	}

	private static Long ejercicio2RCM(Integer a, Integer b) {
		return ejercicio2RCM(a, b, Map2.empty());
	}

//	private static record Tupla(Integer a, Integer b) { // Es conveniente crear este record tupla fuera de la clase e
//														// importarla
//		// En este caso esto no haria falta ya que ya tenemos el tipo IntPair en java
//		public static Tupla of(Integer a, Integer b) {
//			return new Tupla(a, b);
//		}
//	}

	private static Long ejercicio2RCM(Integer a, Integer b, Map<IntPair, Long> map) {
		Long r = map.get(IntPair.of(a, b));
		if (r == null) {
			if (a <= 2 || b <= 2) {
				r = a + b + 0L;
			} else {
				r = a * b + ejercicio2RCM(a - 2, b - 3, map) + ejercicio2RCM(a / 2, b / 3, map);
			}
			map.put(IntPair.of(a, b), r);
		}
		return r;
	}

	private static Long ejercicio2Iterativo(Integer a, Integer b) {
		Long r = null;
		Map<IntPair, Long> map = Map2.empty();
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				if (i <= 2 || j <= 2) {
					r = i + j + 0L;
				} else {
					r = i * j + map.get(IntPair.of(i - 2, j - 3)) + map.get(IntPair.of(i / 2, j / 3));
				}
				map.put(IntPair.of(i, j), r);
			}
		}
		return map.get(IntPair.of(a, b));
	}

}
