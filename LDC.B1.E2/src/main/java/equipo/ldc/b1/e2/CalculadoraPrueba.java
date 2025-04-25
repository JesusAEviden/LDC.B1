package equipo.ldc.b1.e2;

import java.io.IOException;

/**
 *
 * @author usuario24
 */
public class CalculadoraPrueba {
    // IoC: Se usa la fábrica para instanciar la Calculadora.
    // DI: Calculadora no crea sus propias dependencias, las recibe externamente.
    static Calculadora c  = Calculadora.calculadorafactory();

    public static void main(String[] args) throws IOException {
       c.teclear();
       c.resultado();
    }
    
}
