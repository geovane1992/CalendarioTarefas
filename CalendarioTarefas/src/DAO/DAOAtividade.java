package DAO;

import Model.Atividade;
import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Eric
 */
public class DAOAtividade {
// Configura essas variáveis de acordo com o seu banco   
    public void apagar(int codAtividade) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("DELETE FROM Atividade WHERE codAtividade = '" 
                    + codAtividade + "';");

        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }

    public Vector<Atividade> buscarTodos() throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        Vector<Atividade> resultados = new Vector<Atividade>();
        ResultSet rs;
        try {
            rs = con.comando.executeQuery("SELECT * FROM Atividade");
            while (rs.next()) {
                Atividade atividade = new Atividade();
                // pega todos os atributos da atividade 
                atividade.setCodAtividade(rs.getInt("codAtividade"));
                atividade.setNome(rs.getString("nome"));
                atividade.setData((Date) rs.getObject("data"));
                atividade.setObservacao(rs.getString("observacao"));
                atividade.setCodTurma(rs.getInt("codTurma"));
                resultados.add(atividade);
            }

            return resultados;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public Vector<Atividade> buscarTodasDaTurma(int codTurma) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        Vector<Atividade> resultados = new Vector<Atividade>();
        ResultSet rs;
        try {
            rs = con.comando.executeQuery("SELECT * FROM Atividade WHERE codTurma = '" 
                    + codTurma + "';");
            while (rs.next()) {
                Atividade atividade = new Atividade();
                // pega todos os atributos da atividade 
                atividade.setCodAtividade(rs.getInt("codAtividade"));
                atividade.setNome(rs.getString("nome"));
                atividade.setData((Date) rs.getObject("data"));
                atividade.setObservacao(rs.getString("observacao"));
                atividade.setCodTurma(rs.getInt("codTurma"));
                resultados.add(atividade);
            }

            return resultados;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void atualizar(Atividade atividade) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();

        try {

            con.comando.executeUpdate("UPDATE Atividade SET nome = '"
                    + atividade.getNome() + "', data = '"
                    + atividade.getData() + "', observacao = '"
                    + atividade.getObservacao() + "', codTurma = '"
                    + atividade.getCodTurma()
                    + "' WHERE  codAtividade = '" + atividade.getCodAtividade()+ "'");

        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }

    public void insere(Atividade atividade) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("INSERT INTO Atividade VALUES('" 
                    + atividade.getCodAtividade()+ "','"
                    + atividade.getNome() + "','"
                    + atividade.getData() + "','"
                    + atividade.getObservacao() + "','"
                    + atividade.getCodTurma()
                    + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }
}
