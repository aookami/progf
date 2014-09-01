
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a1094785
 */
public class ExecCmd extends Thread{
    
    protected Process proc;
    final String cmd;

    
    public ExecCmd(String cmd){
        this.cmd = cmd;
    }
    
    @Override
    public void run(){
        try{
            //CapturaSaida captura = new CapturaSaida(proc.getInputStream(),new PrintStream(proc.getOutputStream()));
            
            proc = Runtime.getRuntime().exec(cmd);
            
            //captura.start();

            synchronized(proc){
                proc.waitFor();
                
            }
        } 
        catch (IOException ex) {
            System.out.println("Não foi possivel executar o comando.");
        } catch (InterruptedException ex) {
            System.out.println("O processo terminou.");
        }
    }
    
    public synchronized void cancela(){
        if(proc != null)
           proc.destroy();
    }
    
    public synchronized boolean terminado(){
        if(proc != null)
            return !proc.isAlive();
        return false;
    }
    
}
