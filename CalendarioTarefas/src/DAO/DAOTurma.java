package DAO;

import Model.Turma;
import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Henrique
 */
public class DAOTurma {
     // Configura essas variáveis de acordo com o seu banco   
    public void apagar(int codTurma) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("DELETE FROM Turma WHERE codTurma = '" 
                    + codTurma + "';");

        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }

    public Vector<Turma> buscarTodos() throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        Vector<Turma> resultados = new Vector<Turma>();
        ResultSet rs;
        try {
            rs = con.comando.executeQuery("SELECT * FROM Turma");
            while (rs.next()) {
                Turma turma = new Turma();
                // pega todos os atributos da turma 
                turma.setCodigoCurso(rs.getInt("codCurso"));
                turma.setCodigoDisciplina(rs.getInt("codDisciplina"));
                turma.setCodigoTurma(rs.getInt("codTurma"));
                turma.setNomeProfessor(rs.getString("professor"));
                turma.setPeriodo(rs.getString("periodo"));
                turma.setEmailProfessor(rs.getString("emailProfessor"));
                resultados.add(turma);
            }

            return resultados;
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }
    
    public Vector<Integer> buscarTodosCodigos() throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        Vector<Integer> resultados = new Vector<Integer>();
        ResultSet rs;
        try {
            rs = con.comando.executeQuery("SELECT * FROM Turma");
            while (rs.next()) {
                int turma;
                // pega todos os atributos da turma 
                turma = (rs.getInt("codTurma"));
                resultados.add(turma);
            }

            return resultados;
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }

    public void atualizar(Turma turma) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();

        try {

            con.comando.executeUpdate("UPDATE Turma SET periodo = '"
                    + turma.getPeriodo()+ "', professor ='"
                    + turma.getNomeProfessor()+ "', codCurso ='"
                    + turma.getCodigoCurso()+  "', codDisciplina ='"
                    + turma.getCodigoDisciplina() + "', emailProfessor ='"
                    + turma.getEmailProfessor()
                    + "' WHERE  codTurma = '" + turma.getCodigoTurma()+ "'");
           

        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }

    public void insere(Turma turma) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("INSERT INTO Turma VALUES('" 
                    + turma.getCodigoTurma()+ "','"
                    + turma.getPeriodo()+ "','"
                    + turma.getNomeProfessor()+ "','"
                    + turma.getCodigoCurso()+ "','"
                    + turma.getCodigoDisciplina() + "','"
                    + turma.getEmailProfessor()
                    + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }
}
