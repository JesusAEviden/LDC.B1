package equipo.ldc.b1.e2;

import java.io.IOException;

public class RAM {

    private final ALU alu;
    private double resultado;

    public RAM(ALU alu) {
        this.alu = alu;
    }

    public void operar(Teclado tl) throws IOException {
        resultado = tl.nextDouble();
        String operacion = tl.next();
        do {
            
            switch (operacion) {
                case "+" -> resultado = alu.calculaSuma(resultado, tl.nextDouble());
                case "-" -> resultado = alu.calculaResta(resultado, tl.nextDouble());
                case "*" -> resultado = alu.calculaMultiplicacion(resultado, tl.nextDouble());
                case "/" -> resultado = alu.calculaDivision(resultado, tl.nextDouble());
                case "^" -> resultado = alu.calculaPotencia(resultado, tl.nextDouble());

                default -> {
                    if (!operacion.equalsIgnoreCase("=")) {
                        throw new ArithmeticException("Operador: "+operacion+" no dispolible");
                    }
                }
            }
            operacion = tl.next();
        } while (!operacion.equalsIgnoreCase("="));
    }

    public double obtenerResultado() {
        return resultado;
    }
}
