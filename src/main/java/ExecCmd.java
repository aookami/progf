
import java.io.IOException;
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
    final String cmd;

    
    public ExecCmd(String cmd){
        this.cmd = cmd;
    }
    
    @Override
    public void run(){
        try{
            proc = Runtime.getRuntime().exec(cmd);
            wait();
        }catch(InterruptedException e){
        } 
        catch (IOException ex) {
            Logger.getLogger(ExecCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cancela(){
        proc.destroy();
    }
    
    public boolean terminado(){
        return proc.isAlive();
    }
}
