package ejerciciosTema1;

import java.util.List;

import us.lsi.common.List2;
import us.lsi.common.String2;

public class Ejercicio3 {

	// Devolver la posicion en la que esta un numero n en una lista ordenada. Si no
	// esta en la lista, devolver -1.
	// BUSQUEDA DICOTOMICA O BINARIA

	public static void main(String[] args) {
		//
		List<Integer> ls = List2.of(10,20,30,40,50,60,70,80,90,100);
		Integer e = 70;
		String2.toConsole("La posicion de %s == %s", e, posicionRecursiva(ls, e));
	}

	public static Integer posicionRecursiva(List<Integer> ls, Integer e) {
		/*
		 * Nos vamos al elemento del medio de la lista. Si es igual hemos acabado, si es
		 * mas grande nos vamos a la izq y a la inversa asi sucesivamente hasta que
		 * encontremos el numero o nos quedemos con un conjunto vacio
		 * En este caso si la lista tuviera algun numero repetido el metodo nos sacaria la posicion del primero que coincida
		 */
		return posicionRecursiva(ls, e, ls.size() / 2, 0, ls.size());
	}

	private static Integer posicionRecursiva(List<Integer> ls, Integer e, Integer k, Integer i, Integer j) {
		Integer r = null;
		if (i == j) {
			r = -1;
		}else if (ls.get(k).equals(e)) {
			r = k;
		}else if (ls.get(k) > e) {
			r = posicionRecursiva(ls, e, (k + i) / 2, i, k);
		}else {
			r = posicionRecursiva(ls, e, (k + 1 + j) / 2, k + 1, j);
		}
		return r;
	}

}
