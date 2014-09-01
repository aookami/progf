
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Guilherme Jacichen <gui_jaci@utfpr.edu.br>
 */
public class Pratica93 {
   
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        List<ExecCmd> comandos = new ArrayList<>();
        Scanner LER_TEC = new Scanner(System.in);
        String cmd;
        
        while(true){
            cmd = LER_TEC.next();      

            if(!cmd.toLowerCase().equals("fim")){
            comandos.add(new ExecCmd(cmd));
            comandos.get(comandos.size()-1).start();
            }
        }
        
    }
}
