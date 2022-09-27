package ejercicios;

import java.util.List;

import us.lsi.common.List2;

public class Ejercicio1 {

	/* Implementar un metodo que indique si una lista de numeros esta ordenada */

	public static void main(String[] args) {
		// Testeos de las funciones de este ejercicio
		List<Integer> ls = List2.of(1,2,3,4,5,6,7,8,9,0);
		System.out.println("Testeo de estaOrdenada: " + estaOrdenada(ls));
	}
	
	/* f(ls) = f'(ls, true, 0); f'(ls, r, i): 
	 * 									r, i = |ls| - 1
	 * 									f'(ls, ls[i] <= ls[i+1], i + 1*/
	
	public static Boolean estaOrdenada(List<Integer> ls) {
		return estaOrdenada(ls, true, 0);
	}

	private static Boolean estaOrdenada(List<Integer> ls, Boolean b, Integer i) {
		//
		Boolean r = null;
		if(b == false || i == ls.size() -1 ) {
			r = b;
		} else {
			r = estaOrdenada(ls, ls.get(i) <= ls.get(i + 1), i+1);
		}
		return r;
	}
	
}
