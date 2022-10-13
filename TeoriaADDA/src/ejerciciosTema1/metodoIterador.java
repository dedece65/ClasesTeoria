package ejerciciosTema1;

import java.util.Iterator;

import us.lsi.common.Files2;

public class metodoIterador {

	/*
	 * Implementar un metodo que itere sobre un fichero de enteros devolviendo la
	 * suma de los impares
	 */

	public static Integer sumaImparesRecursivoFinal(String f) {
		Iterator<String> it = Files2.streamFromFile(f).iterator();
		return sumaImparesReucursivoFinal(it, 0);
	}

	private static Integer sumaImparesReucursivoFinal(Iterator<String> it, Integer ac) {
		Integer r = ac;
		if (it.hasNext()) {
			Integer n = Integer.valueOf(it.next());
			r += n % 2 == 1 ? n : 0;
			r = sumaImparesReucursivoFinal(it, r);
		}
		return r;
	}

	public static Integer sumaImparesIterativa(String f) {
		Iterator<String> it = Files2.streamFromFile(f).iterator();
		Integer r = 0;
		while (it.hasNext()) {
			Integer n = Integer.valueOf(it.next());
			r += n % 2 == 1 ? n : 0;
		}
		return r;
	}

	public static void main(String[] args) {
		String file1 = "ficheros/numerosPrueba";
		System.out.println("Recursiva: \n" + sumaImparesRecursivoFinal(file1));
		System.out.println("Iterativa: \n" + sumaImparesIterativa(file1));
	}

}
