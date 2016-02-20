package Controller;

import DAO.DAOAluno;
import Model.Aluno;
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
                dao.insere(aluno);
            }
            System.out.println("Alunos inseridos no banco.");
        } else {
            System.out.println("Nenhum aluno foi identificado no arquivo.");
        }       
    }
}
