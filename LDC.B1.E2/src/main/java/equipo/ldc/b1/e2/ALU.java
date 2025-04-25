/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo.ldc.b1.e2;

/**
 *
 * @author usuario
 */
public class ALU {

    public double calculaPotencia(double base, double exponente) {
        int exp = (int) exponente;
        if (exp == 0) {
            return 1;
        }

        double potencia = 1;

        if (exp > 0) {
            while ((exp--) > 0) {
                potencia *= base;
            }
        } else {
            while ((exp++) < 0) {
                potencia /= base;
            }
        }

        return potencia;
    }

    public double calculaSuma(double sumando1, double sumando2) {
        return sumando1 + sumando2;
    }
    
    public double calculaResta(double minuendo, double sustraendo) {
        return minuendo - sustraendo;
    }

    public double calculaMultiplicacion(double multiplicando, double multiplicador) {
        return multiplicando * multiplicador;
    }
    
    public double calculaDivision(double dividendo, double divisor){
        if (divisor == 0) {
            throw new ArithmeticException("No puedes dividir entre cero");
        }    
        return dividendo/divisor;
    }
}
