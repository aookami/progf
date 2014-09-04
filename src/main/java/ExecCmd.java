
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
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
    String cmd;

    
    public ExecCmd(String cmd) throws IOException{
        this.cmd = cmd;
        
    }
    public void setCmd(String cmd){
        this.cmd = cmd;
    }
    /*@Override
    public void run(){
        try {
            Runtime.getRuntime().exec(this.cmd);
        } catch (IOException ex) {
            Logger.getLogger(ExecCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    @Override
    public void run(){
        try{
            //CapturaSaida captura = new CapturaSaida(proc.getInputStream(),System.out);
            
            proc = Runtime.getRuntime().exec(cmd);
            
           // captura.start();

            synchronized(proc){
                proc.waitFor();
                
            }
        } 
        catch (IOException ex) {
            System.out.println("Não foi possivel executar o comando.");
        } catch (InterruptedException ex) {
            Logger.getLogger(ExecCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void cancela(){   
        if(proc!=null)
           proc.destroy();
           System.out.println("CANCELAAAAA");      
    }
    
    public synchronized boolean terminado(){
        if(proc != null)
            return !proc.isAlive();
        return false;
    }
    
}
