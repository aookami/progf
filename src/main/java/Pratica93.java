
import java.io.IOException;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Guilherme Jacichen <gui_jaci@utfpr.edu.br>
 */
public class Pratica93 {
    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("oi");
        CapturaSaida out = new CapturaSaida(proc.getInputStream());

        out.start();

        int status = proc.waitFor();
        System.out.println("Processo terminado com status " + status);
    }
}
