package DAO;

import Classes.Aluno;
import Classes.Atividade;
import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

/**
 *
 * @author Eric
 */
public class DaoAtividade {
// Configura essas variáveis de acordo com o seu banco   
    public void apagar(int codAtividade) {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("DELETE FROM Atividade WHERE codAtividade = '" 
                    + codAtividade + "';");

        } catch (SQLException e) {
            imprimeErro("Erro ao apagar Atividade", e.getMessage());
        } finally {
            con.fechar();
        }
    }

    public Vector<Atividade> buscarTodos() {
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
                atividade.setData((Calendar) rs.getObject("data"));
                atividade.setObservacao(rs.getString("observacao"));
                resultados.add(atividade);
            }

            return resultados;
        } catch (SQLException e) {
            imprimeErro("Erro ao buscar Atividade", e.getMessage());
            return null;
        }
    }

    public void atualizar(Atividade atividade) {
        Conexao con = new Conexao();
        con.getConexao();

        try {

            con.comando.executeUpdate("UPDATE Atividade SET nome = '"
                    + atividade.getNome()
                    + "' WHERE  codAtividade = '" + atividade.getCodAtividade()+ "'");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Atividade!");
        } finally {
            con.fechar();
        }
    }

    public void insere(Atividade atividade) {
        Conexao con = new Conexao();
        con.getConexao();
        try {
            con.comando.executeUpdate("INSERT INTO Atividade VALUES('" 
                    + atividade.getCodAtividade()+ "','"
                    + atividade.getNome() + "','"
                    + atividade.getData() + "','"
                    + atividade.getObservacao()
                    + "')");
        } catch (SQLException e) {
            imprimeErro("Erro ao inserir Atividade", e.getMessage());
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
