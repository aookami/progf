
import java.util.List;
import java.util.TimerTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruno
 */
public class ProcessCheck extends TimerTask {
    ExecCmd cmd;
    
    public ProcessCheck(ExecCmd cmd){
        this.cmd = cmd;
    }

    @Override
    public void run() {
        if(cmd.terminado()){
            cmd.cancela();
            
        }else
            System.out.println(cmd.toString() + "nao terminou");
    }
    
}
