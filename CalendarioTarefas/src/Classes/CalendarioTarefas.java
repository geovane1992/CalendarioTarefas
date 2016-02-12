/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Conexao.Conexao;

/**
 *
 * @author GAOliveira
 */
public class CalendarioTarefas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexao cn = new Conexao();
        System.out.println(cn.getConexao());

    }
    
}
