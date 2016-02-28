package DAO;

import Conexao.Conexao;
import Model.Aluno;
import Model.Atividade;
import Model.Disciplina;
import Model.Turma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author GAOliveira
 */
public class DAOEmail {
    
    public static Vector<Turma> buscarTurma(int codTurma) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        Vector<Turma> resultados = new Vector<Turma>();
        ResultSet rs;
        try {
            rs = con.comando.executeQuery("SELECT * FROM Turma WHERE codTurma = '" 
                    + codTurma + "';");
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
        }
    }
    
    public static Vector<Aluno> buscaAlunos(int codTurma) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        Vector<Aluno> resultados = new Vector<Aluno>();
        ResultSet rs;
        try {
            rs = con.comando.executeQuery("SELECT * FROM Aluno WHERE codTurma = '" 
                    + codTurma + "';");
            while (rs.next()) {
                Aluno aluno = new Aluno();
                // pega todos os atributos do aluno 
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCodDisciplina(rs.getInt("codDisciplina"));
                aluno.setCodTurma(rs.getInt("codTurma"));
                resultados.add(aluno);
            }

            return resultados;
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
    }
    
    public static Vector<Atividade> buscarAtividades(int codTurma, int codAtividade) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        Vector<Atividade> resultados = new Vector<Atividade>();
        ResultSet rs;
        try {
            if(codAtividade != 0){
            rs = con.comando.executeQuery("SELECT * FROM Atividade WHERE codTurma = '" 
                    + codTurma + "' and codAtividade = '" + codAtividade + "';");
            }
            else{
                rs = con.comando.executeQuery("SELECT * FROM Atividade WHERE codTurma = '" 
                    + codTurma + "';");
            }
            
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
    
    public static Vector<Disciplina> buscarDsiciplina(int codTurma) throws SQLException {
        Conexao con = new Conexao();
        con.getConexao();
        Vector<Disciplina> resultados = new Vector<Disciplina>();
        ResultSet rs;
        try {
            
            rs = con.comando.executeQuery("SELECT * FROM Turma INNER JOIN Disciplina on Turma.codTurma = '"
                    + codTurma + "and Disciplina.codDisciplina = Turma.codDisciplina';");
            
            
            while (rs.next()) {
                Disciplina temp = new Disciplina();  
            // pega todos os atributos da Disciplina 
            temp.setCodDisciplina(rs.getInt("codDisciplina"));  
            temp.setNome(rs.getString("nome"));   
            resultados.add(temp); 
            }

            return resultados;
        } catch (SQLException e) {
            throw e;
        }
    }
    
}
