package Controller;

import Model.Aluno;
import DAO.DAOAluno;
import java.util.Scanner;
import java.util.Vector;

public class ControleAluno {
    
    public static void controleAluno(int opcaoSubmenu){
    
        DAOAluno daoAluno = new DAOAluno();
        Scanner scanner = new Scanner(System.in);
        int matriculaAluno;
        String nomeAluno;
        String emailAluno;
        int codDisciplina;

        switch (opcaoSubmenu) {
            case 1: //insere
                System.out.print("Digite a matricula do aluno: ");
                matriculaAluno = Integer.parseInt(scanner.nextLine());
                System.out.print("Digite o nome do aluno: ");
                nomeAluno = scanner.nextLine();
                System.out.print("Digite o email do aluno: ");
                emailAluno = scanner.nextLine();
                System.out.print("Digite o codigo da Dsciplina: ");
                codDisciplina = Integer.parseInt(scanner.nextLine());

                Aluno novoAluno = new Aluno(matriculaAluno, nomeAluno, emailAluno, codDisciplina);
                daoAluno.insere(novoAluno);
                break;

            case 2: // atualiza
                System.out.print("Digite a matricula do aluno a ser modificado: ");
                matriculaAluno = Integer.parseInt(scanner.nextLine());
                System.out.println("Digite o novo nome do aluno: ");
                nomeAluno = scanner.nextLine();
                System.out.println("Digite o novo email do aluno: ");
                emailAluno = scanner.nextLine();
                System.out.print("Digite o codigo da Dsciplina: ");
                codDisciplina = Integer.parseInt(scanner.nextLine());

                Aluno alunoAtualizado = new Aluno(matriculaAluno, nomeAluno, emailAluno, codDisciplina);
                daoAluno.atualizar(alunoAtualizado);
                break;

            case 3: // exclui
                System.out.print("Digite a matricula do aluno a ser excluido: ");
                matriculaAluno = Integer.parseInt(scanner.nextLine());
                daoAluno.apagar(matriculaAluno);
                break;

            case 4: // lista
                Vector<Aluno> alunos = daoAluno.buscarTodos();

                for (int i = 0; i < alunos.size(); i++) {
                    StringBuilder stringAluno = new StringBuilder();
                    stringAluno.append(alunos.get(i).getMatricula());
                    stringAluno.append(" - ");
                    stringAluno.append(alunos.get(i).getNome());
                    stringAluno.append(" - ");
                    stringAluno.append(alunos.get(i).getEmail());
                    stringAluno.append(" - ");
                    stringAluno.append(alunos.get(i).getCodDisciplina());
                    System.out.println(stringAluno.toString());
                }
                break;

            
        }
        
    }
    
}
