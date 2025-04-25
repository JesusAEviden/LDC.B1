/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo.ldc.b1.e2;

import java.io.IOException;

/**
 *
 * @author usuario24
 */
public class Calculadora {

    private final RAM ram;
    private final Teclado tl;

    public Calculadora(RAM ram, Teclado tl) {
        this.ram = ram;
        this.tl = tl;
    }

    public void teclear() throws IOException {
        System.out.println("CALCULADORA SIMPLE"
                + "\nReglas:"
                + "\n1-Las operaciones son de izquierda a derecha."
                + "\n2-Debes dejar un espacio entre los números y los operadores."
                + "\n3-Para terminar la entrada debes escribir =."
                + "\n\nLista de operadores admitidos:"
                + "\n+ - * / ^\n");
        ram.operar(tl);
    }

    public void resultado() {
        System.out.println("\nEL RESULTADO DE LA OPERACIÓN: " + tl.getOperacion()
                + " " + ram.obtenerResultado());
    }

    public static Calculadora calculadorafactory(){
       // DI: Calculadora no crea sus propias dependencias, las recibe externamente.     
       ALU alu = new ALU();
       RAM ramC = new RAM(alu);
       Teclado tlC = new Teclado();
       return new Calculadora(ramC, tlC);
    }
}
