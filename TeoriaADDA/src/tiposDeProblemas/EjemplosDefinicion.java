package tiposDeProblemas;


import java.util.stream.Stream;

import us.lsi.common.String2;

public class EjemplosDefinicion {
    public static void main(String[] args) {
    	String2.toConsole("Recursiva no final: " +  recNoFinal(200, 10));
    	String2.toConsole("Recursiva final: " +  recFinal(200, 10));
    	String2.toConsole("Iterativa: " +  iterativa(200, 10));
    	String2.toConsole("Funcional: " + funcional(200, 10));
    }
    /*
     * f(a,b):
     *   a + b; a<2
     *   f(a-2, b) + b/2; en otro caso
     * como solamente tenemos 2 lineas habra 2 casos: el primero con un if y el segundo con un else
     * */
    public static Integer recNoFinal(Integer a, Integer b) { //definicion
        //caso base
        Integer res = null;
        if (a < 2) {
            res = a + b;
        }else {
            res =  b / 2 + recNoFinal(a - 2, b);
        }
        return res;
    }
    public static Integer recFinal(Integer a, Integer b) { //Recursiva Final
        //
        Integer ac = 0;
        return recFinal(ac, a, b);
    }
    private static Integer recFinal(Integer ac, Integer a, Integer b) { //Recursiva Final
        //la operacion que le aplico a la base de acumulacion es la suma en este caso
        Integer res = null;
        if (a < 2) {
            res = ac + a + b;
        }else {
            res = recFinal(ac + b / 2, a - 2, b);
        }
        return res;
    }
    public static Integer iterativa(Integer a, Integer b) {
        int ac = 0;
        while (a >= 2) {
            ac += b/2;
            a -= 2;
        }
        return ac + (a + b);
    }
    public static Integer funcional(Integer a, Integer b) {
        //queremos generar la secuencia que emula la evolucion de las variables en el bucle del iterativo
        TuplaE1 t = Stream.iterate(TuplaE1.seed(a, b), TuplaE1::next).filter(e -> e.a() < 2).findFirst().get();
        return t.ac() + t.a() + b;
    }

}
