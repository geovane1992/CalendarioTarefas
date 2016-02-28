/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Curso;
import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Henrique
 */
public class DAOCurso {
    
    public void apagar(int codigoCurso) throws SQLException { 
       Conexao con = new Conexao();
       con.getConexao();  
      try {  
         con.comando.executeUpdate("DELETE FROM Curso WHERE codCurso = '" + codigoCurso + "';");
         
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        } 
   }  
  
   public Vector<Curso> buscarTodos() throws SQLException {  
      Conexao con = new Conexao();
       con.getConexao();  
      Vector<Curso> resultados = new Vector<Curso>();  
      ResultSet rs;  
      try {  
         rs = con.comando.executeQuery("SELECT * FROM Curso");  
         while (rs.next()) {  
            Curso curso = new Curso();  
            // pega todos os atributos do Curso 
            curso.setCodCurso(rs.getInt("codCurso"));  
            curso.setNome(rs.getString("nome"));   
            resultados.add(curso);  
         }  
         
         return resultados;  
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        } 
   }  
   
   public Vector<Integer> buscarTodosCodigo() throws SQLException {  
      Conexao con = new Conexao();
       con.getConexao();  
      Vector<Integer> resultados = new Vector<Integer>();  
      ResultSet rs;  
      try {  
         rs = con.comando.executeQuery("SELECT * FROM Curso");  
         while (rs.next()) {  
            int curso;  
            // pega todos os atributos do Curso 
            curso = (rs.getInt("codCurso"));     
            resultados.add(curso);  
         }  
         
         return resultados;  
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        } 
   }  
  
   public void atualizar(Curso curso) throws SQLException {  
      Conexao con = new Conexao();
       con.getConexao();   
  
      try {  

         con.comando.executeUpdate("UPDATE Curso SET nome = '"  
            + curso.getNome()
            + "' WHERE  codCurso = '" + curso.getCodCurso()+"'"); 
         
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        } 
   }  
  
   public void insere(Curso curso) throws SQLException{  
      Conexao con = new Conexao();
       con.getConexao();   
      try {  
         con.comando.executeUpdate("INSERT INTO Curso VALUES('" + curso.getCodCurso()+ "','" 
               + curso.getNome()
               + "')");  
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fechar();
        }
   }
}
