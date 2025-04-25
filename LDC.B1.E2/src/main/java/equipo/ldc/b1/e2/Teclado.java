package equipo.ldc.b1.e2;

import java.util.*;
import java.io.*;

//Me base en el FastReader, una clase usada en competiciones
public class Teclado {

    BufferedReader br;
    StringTokenizer st;
    String operacion = "";

    public Teclado() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            operacion += br.readLine() + " ";
            st = new StringTokenizer(operacion);
        }
        return st.nextToken();
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }

    public int nextDouble() throws IOException {
        return Integer.parseInt(next());
    }

    public void close() throws IOException {
        br.close();
    }
    
    public String getOperacion(){
        return operacion;
    }
}
