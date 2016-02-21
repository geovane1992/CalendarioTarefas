package DAO;

import Model.Aluno;
import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Eric
 */
public class DAOAluno {

    // Configura essas variáveis de acordo com o seu banco   
    public void apagar(int matricula) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("DELETE FROM Aluno WHERE matricula = '" 
                    + matricula + "';");

        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }

    public Vector<Aluno> buscarTodos() throws SQLException {
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
                aluno.setCodDisciplina(rs.getInt("codDisciplina"));
                resultados.add(aluno);
            }

            return resultados;
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }

    public void atualizar(Aluno aluno) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();

        try {

            con.comando.executeUpdate("UPDATE Aluno SET nome = '"
                    + aluno.getNome() + "', email = '"
                    + aluno.getEmail() + "', codDisciplina = '"
                    + aluno.getCodDisciplina()
                    + "' WHERE  matricula = '" + aluno.getMatricula() + "'");

        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }

    public void insere(Aluno aluno) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("INSERT INTO Aluno VALUES('" 
                    + aluno.getMatricula() + "','"
                    + aluno.getNome() + "','"
                    + aluno.getEmail() + "','"
                    + aluno.getCodDisciplina()
                    + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }
}
