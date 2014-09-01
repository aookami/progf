
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
            System.out.print("comando> ");
            cmd = LER_TEC.next();      

            if(!cmd.toLowerCase().equals("fim")){
                comandos.add(new ExecCmd(cmd));
                comandos.get(comandos.size()-1).start();
                
            }else{
                
                int soma = 0;
                char resposta;
               
                for(ExecCmd p: comandos)
                    soma += p.terminado()?0:1;
                
                System.out.print("Há " + soma + 
                        " processos em execução. Deseja terminá-los? <y/n>");
                
                do
                    resposta = LER_TEC.next().charAt(0);
                while(resposta != 'y' && resposta != 'n');
                
                if(resposta == 'n')
                    continue;
                
                for(ExecCmd p: comandos)
                    p.cancela();
                
                break;
            }
        }
        
        System.out.print("");
    }
}
