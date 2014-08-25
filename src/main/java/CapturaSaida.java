
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a1094785
 */
public class CapturaSaida extends Thread {

    private final InputStream is;
    private final PrintStream ps;


    public CapturaSaida(InputStream is, PrintStream ps) {
        this.is = is;
        this.ps = ps;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linha;
            while ((linha = br.readLine()) != null) {
                ps.println(linha);
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
