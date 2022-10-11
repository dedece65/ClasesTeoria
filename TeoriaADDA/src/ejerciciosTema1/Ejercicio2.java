package ejerciciosTema1;

import java.util.List;

import us.lsi.common.List2;

public class Ejercicio2 {

	// Escribir un metodo que dado una lista obtenga su inversa
	
	public static void main(String[] args) {
		// Testeo de las funciones de este ejercicio
		List<Integer> ls = List2.of(0,7,9,0,1);
		System.out.println("La lista original es: "+ ls);
		System.out.println("La lista invertida de forma iterativa es: "+ invertirListaIterativo(ls));
		System.out.println("La lista invertida de forma recursiva es: "+ invertirLista(ls));
	}
	
	/* (ls, b0 == 0, e0 == 0) 
	 * c(b,e) == b.add(0, ls.get(e))*/
	
	public static List<Integer> invertirListaIterativo(List<Integer> ls){
		List<Integer> b = List2.empty();
		Integer e = 0;
		while(e < ls.size()) {
			b.add(0, ls.get(e));
			e += 1;
		}
		return b;
	}
	
	public static List<Integer> invertirLista(List<Integer> ls){
		return invertirLista(ls, List2.empty(), 0);
	}

	private static List<Integer> invertirLista(List<Integer> ls, List<Integer> b, Integer e) {
		//
		if(e <= ls.size() - 1) {
			b.add(0, ls.get(e));
			b = invertirLista(ls, b, e + 1);
		}
		return b;
	}
	
}
