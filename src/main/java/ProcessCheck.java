
import java.util.List;
import java.util.TimerTask;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    JTable Table;
    List<ExecCmd> lista;
    DefaultTableModel model;
    
    public ProcessCheck(ExecCmd cmd, JTable Table, List<ExecCmd> lista, DefaultTableModel model){
        this.cmd = cmd;
        this.Table = Table;
        this.lista = lista;
        this.model = model;
    }
    
    public void RemoveTable(){
        //this.cmd = cmd;
        this.cmd.isonline = 0;
    }

    @Override
    public void run() {
        if(cmd.terminado()){
            RemoveTable();
            System.out.println(cmd.toString() + "TERMINADO!");
             lista.get(Table.getSelectedRow()).cancela();
             lista.remove(Table.getSelectedRow());        
             Table.setModel(Table.getModel());
             model.removeRow(Table.getSelectedRow());
             cmd.cancela();
            
        }else
            System.out.println(cmd.toString() + "nao terminou");
    }
    
}
