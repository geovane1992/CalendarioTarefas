/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Turma;
import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Henrique
 */
public class DaoTurma {
     // Configura essas variáveis de acordo com o seu banco   
    public void apagar(int codTurma) {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("DELETE FROM Turma WHERE codTurma = '" 
                    + codTurma + "';");

        } catch (SQLException e) {
            imprimeErro("Erro ao apagar Turma", e.getMessage());
        } finally {
            con.fechar();
        }
    }

    public Vector<Turma> buscarTodos() {
        Conexao con = new Conexao();
        con.getConexao();
        Vector<Turma> resultados = new Vector<Turma>();
        ResultSet rs;
        try {
            rs = con.comando.executeQuery("SELECT * FROM Turma");
            while (rs.next()) {
                Turma turma = new Turma();
                // pega todos os atributos da turma 
                turma.setCodigoAtividade(rs.getInt("codAtividade"));
                turma.setCodigoCurso(rs.getInt("codCurso"));
                turma.setCodigoDisciplina(rs.getInt("codDisciplina"));
                turma.setCodigoTurma(rs.getInt("codTurma"));
                turma.setNomeProfessor(rs.getString("professor"));
                turma.setPeriodo(rs.getString("periodo"));
                resultados.add(turma);
            }

            return resultados;
        } catch (SQLException e) {
            imprimeErro("Erro ao buscar Turma", e.getMessage());
            return null;
        }
    }

    public void atualizar(Turma turma) {
        Conexao con = new Conexao();
        con.getConexao();

        try {

            con.comando.executeUpdate("UPDATE Turma SET codTurma = '"
                    + turma.getCodigoTurma()+ "', periodo = '"
                    + turma.getPeriodo()+ "', professor"
                    + turma.getNomeProfessor()+ "', codCurso"
                    + turma.getCodigoCurso()+ "', codAtividade"
                    + turma.getCodigoAtividade()+ "', codDisciplina"
                    + turma.getCodigoDisciplina()
                    + "' WHERE  codTurma = '" + turma.getCodigoTurma()+ "'");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Turma!");
        } finally {
            con.fechar();
        }
    }

    public void insere(Turma turma) {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("INSERT INTO Turma VALUES('" 
                    + turma.getCodigoTurma()+ "','"
                    + turma.getPeriodo()+ "','"
                    + turma.getNomeProfessor()+ "','"
                    + turma.getCodigoCurso()+ "','"
                    + turma.getCodigoAtividade()+ "','"
                    + turma.getCodigoDisciplina()
                    + "')");
        } catch (SQLException e) {
            imprimeErro("Erro ao inserir Turma", e.getMessage());
        } finally {
            con.fechar();
        }
    }

    private void imprimeErro(String msg, String msgErro) {
        System.out.println(msg + " Erro crítico " + 0);
        System.err.println(msg);
        System.out.println(msgErro);
    }
}
