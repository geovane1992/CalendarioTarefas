package DAO;

import Classes.Aluno;
import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Eric
 */
public class DaoAluno {

    // Configura essas variáveis de acordo com o seu banco   
    public void apagar(int matricula) {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("DELETE FROM Aluno WHERE matricula = '" 
                    + matricula + "';");

        } catch (SQLException e) {
            imprimeErro("Erro ao apagar Aluno", e.getMessage());
        } finally {
            con.fechar();
        }
    }

    public Vector<Aluno> buscarTodos() {
        Conexao con = new Conexao();
        con.getConexao();
        Vector<Aluno> resultados = new Vector<Aluno>();
        ResultSet rs;
        try {
            rs = con.comando.executeQuery("SELECT * FROM Aluno");
            while (rs.next()) {
                Aluno aluno = new Aluno();
                // pega todos os atributos do aluno 
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                resultados.add(aluno);
            }

            return resultados;
        } catch (SQLException e) {
            imprimeErro("Erro ao buscar Aluno", e.getMessage());
            return null;
        }
    }

    public void atualizar(Aluno aluno) {
        Conexao con = new Conexao();
        con.getConexao();

        try {

            con.comando.executeUpdate("UPDATE Aluno SET nome = '"
                    + aluno.getNome()
                    + "' WHERE  matricula = '" + aluno.getMatricula() + "'");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Aluno!");
        } finally {
            con.fechar();
        }
    }

    public void insere(Aluno aluno) {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("INSERT INTO Aluno VALUES('" 
                    + aluno.getMatricula() + "','"
                    + aluno.getNome() + "','"
                    + aluno.getEmail()
                    + "')");
        } catch (SQLException e) {
            imprimeErro("Erro ao inserir Aluno", e.getMessage());
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
