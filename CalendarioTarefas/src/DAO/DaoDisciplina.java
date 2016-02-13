package DAO;


import Classes.Disciplina;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Conexao.Conexao;
import java.util.Vector;

/**
 *
 * @author GAOliveira
 */
public class DaoDisciplina {  
   // Configura essas variáveis de acordo com o seu banco   
  
   public void apagar(int cod) { 
       Conexao con = new Conexao();
       con.getConexao();  
      try {  
         con.comando.executeUpdate("DELETE FROM Disciplina WHERE codDisciplina = '" + cod + "';");
         
      } catch (SQLException e) {  
         imprimeErro("Erro ao apagar Disciplina", e.getMessage());  
      } finally {  
         con.fechar();
      }  
   }  
  
   public Vector<Disciplina> buscarTodos() {  
      Conexao con = new Conexao();
       con.getConexao();  
      Vector<Disciplina> resultados = new Vector<Disciplina>();  
      ResultSet rs;  
      try {  
         rs = con.comando.executeQuery("SELECT * FROM Disciplina");  
         while (rs.next()) {  
            Disciplina temp = new Disciplina();  
            // pega todos os atributos da Disciplina 
            temp.setCodDisciplina(rs.getInt("codDisciplina"));  
            temp.setNome(rs.getString("nome"));  
            temp.setMatricula(rs.getInt("matricula")); 
            resultados.add(temp);  

         }  
         
         return resultados;  
      } catch (SQLException e) {  
         imprimeErro("Erro ao buscar Disciplina", e.getMessage());  
         return null;  
      }  
   }  
  
   public void atualizar(Disciplina disciplina) {  
      Conexao con = new Conexao();
       con.getConexao();   
  
      try {  

         con.comando.executeUpdate("UPDATE Disciplina SET nome = '"  
            + disciplina.getNome()+ "' , matricula = '" + disciplina.getMatricula()
            + "' WHERE  codDisciplina = '" + disciplina.getCodDisciplina()+"'"); 
         
      } catch (SQLException e) {  
         JOptionPane.showMessageDialog(null, "Erro ao atualizar Disciplina!");  
      } finally {  
         con.fechar();  
      }  
   }  
  
   public void insere(Disciplina disciplina){  
      Conexao con = new Conexao();
       con.getConexao();   
      try {  
         con.comando.executeUpdate("INSERT INTO Disciplina VALUES('" + disciplina.getCodDisciplina()+ "','" 
               + disciplina.getNome() + "','" + disciplina.getMatricula()
               + "')");  
      } catch (SQLException e) {  
         imprimeErro("Erro ao inserir Disciplina", e.getMessage());  
      } finally {  
         con.fechar();  
      }  
   }
   
   private void imprimeErro(String msg, String msgErro) {  
      JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);  
      System.err.println(msg);  
      System.out.println(msgErro);  
     // System.exit(0);  
   } 


}  

 
  
