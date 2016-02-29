package Conexao;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author GAOliveira
 */
public class Conexao {
    
    public Statement comando;
    public Connection connection;
    
public Connection getConexao() {  
    
    
        try {  
            // Carregando o JDBC Driver padrão  
            String driverName = "com.mysql.jdbc.Driver";                          
            Class.forName(driverName);  
            // Configurando a nossa conexão com um banco de dados//  
            String serverName = "72.13.93.206:3307";    //caminho do servidor do BD  
            String mydatabase ="geovane1992";        //nome do banco de dados  
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;  
            String username = "geovane1992";        //nome de um usuário do BD        
            String senha = "Geo1992*";      // senha de acesso 
            connection = (Connection) DriverManager.getConnection(url, username, senha); 
            comando = (Statement) connection.createStatement(); 
            return connection;  
        }  catch (ClassNotFoundException e) {  //Driver não encontrado  
            JOptionPane.showMessageDialog(null,"O driver expecificado nao foi encontrado!");
            return null;  
        } catch (SQLException e) {  
            //Não conseguindo se conectar ao banco 
            JOptionPane.showMessageDialog(null,"Nao foi possivel conectar ao Banco de Dados!");
            System.out.println(e);
            return null;  
        }  
   
   
    
}

public void fechar() {  
      try {  
         comando.close();  
         connection.close();  
         /* Aqui vinha um print informando que a conexao foi fechada.
            Para isso nao ficar aparecendo toda hora pro usuario, removi o print. */
      } catch (SQLException e) {  
         System.out.println("Erro ao fechar conexão");  
      }  
   }  

  
}

