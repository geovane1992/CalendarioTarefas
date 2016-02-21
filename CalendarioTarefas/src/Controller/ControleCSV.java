package Controller;

import DAO.DAOAluno;
import Model.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Eric
 */
public class ControleCSV {

    public static void controleCSV() {
        
        List<Aluno> listaAlunos = new ArrayList<>();
        LeitorCSV leitorCSV = new LeitorCSV();
        DAOAluno dao = new DAOAluno();
        Scanner scanner = new Scanner(System.in);
        String caminhoArquivo;
        
        System.out.println("Digite o caminho do arquivo CSV:");
        caminhoArquivo = scanner.nextLine();
        listaAlunos = leitorCSV.lerListaAlunos(caminhoArquivo);
        
        if (!listaAlunos.isEmpty()) {
            for (Aluno aluno : listaAlunos) {
                try {
                    dao.insere(aluno);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel inserir o aluno.\n"+ex);
                }
            }
            System.out.println("Alunos inseridos no banco.");
        } else {
            System.out.println("Nenhum aluno foi identificado no arquivo.");
        }       
    }
}
