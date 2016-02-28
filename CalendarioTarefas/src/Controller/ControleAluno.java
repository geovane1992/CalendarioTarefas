package Controller;

import Model.Aluno;
import DAO.DAOAluno;
import DAO.DAOCurso;
import DAO.DAODisciplina;
import DAO.DAOTurma;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class ControleAluno {

    public static void controleAluno(int opcaoSubmenu) throws SQLException {

        DAOAluno daoAluno = new DAOAluno();
        DAODisciplina daodisciplina = new DAODisciplina();
        DAOTurma daoturma = new DAOTurma();
        Scanner scanner = new Scanner(System.in);
        int matriculaAluno;
        String nomeAluno;
        String emailAluno;
        int codDisciplina;
        int codTurma;
        Vector<Integer> listDisciplinas;
        Vector<Integer> listTurma;
        
        listDisciplinas = daodisciplina.buscarTodosCodigo();
        listTurma = daoturma.buscarTodosCodigos();
        

        switch (opcaoSubmenu) {
            case 1: //insere
                boolean disciplinaok = false;
                boolean turmaok = false;
                
                
                
                System.out.print("Digite a matricula do aluno: ");
                matriculaAluno = Integer.parseInt(scanner.nextLine());
                System.out.print("Digite o nome do aluno: ");
                nomeAluno = scanner.nextLine();
                System.out.print("Digite o email do aluno: ");
                emailAluno = scanner.nextLine();
                
                System.out.print("Digite o codigo da Disciplina: ");
                codDisciplina = Integer.parseInt(scanner.nextLine());
                while(disciplinaok == false){
                    if(listDisciplinas.contains(codDisciplina)){
                        disciplinaok = true;
                    }
                    else{
                    System.out.println("Disciplina não exise informe novamente!");
                    codDisciplina = Integer.parseInt(scanner.nextLine()); 
                    }
                      
                }
                
                System.out.print("Digite o codigo da Turma: ");
                codTurma = Integer.parseInt(scanner.nextLine());
                while(turmaok == false){
                    if(listTurma.contains(codTurma)){
                        turmaok = true;
                    }
                    else{
                    System.out.println("Turma não exise informe novamente!");
                    codTurma = Integer.parseInt(scanner.nextLine());
                    }
                      
                }

                Aluno novoAluno = new Aluno(matriculaAluno, nomeAluno, emailAluno, codDisciplina, codTurma);
                try {
                    daoAluno.insere(novoAluno);
                } catch (SQLException ex) {                   
                    System.err.println("Erro: Nao foi possivel inserir o aluno.\n"+ex);
                }

                break;

            case 2: // atualiza
                boolean disciplinaok2 = false;
                boolean turmaok2 = false;
                
                System.out.print("Digite a matricula do aluno a ser modificado: ");
                matriculaAluno = Integer.parseInt(scanner.nextLine());
                System.out.println("Digite o novo nome do aluno: ");
                nomeAluno = scanner.nextLine();
                System.out.println("Digite o novo email do aluno: ");
                emailAluno = scanner.nextLine();
                System.out.print("Digite o codigo da Dsciplina: ");
                codDisciplina = Integer.parseInt(scanner.nextLine());
                while(disciplinaok2 == false){
                    if(listDisciplinas.contains(codDisciplina)){
                        disciplinaok2 = true;
                    }
                    else{
                    System.out.println("Disciplina não exise informe novamente!");
                    codDisciplina = Integer.parseInt(scanner.nextLine()); 
                    }
                      
                }
                
                System.out.print("Digite o codigo da Turma: ");
                codTurma = Integer.parseInt(scanner.nextLine());
                while(turmaok2 == false){
                    if(listTurma.contains(codTurma)){
                        turmaok2 = true;
                    }
                    else{
                    System.out.println("Turma não exise informe novamente!");
                    codTurma = Integer.parseInt(scanner.nextLine());
                    }
                      
                }

                Aluno alunoAtualizado = new Aluno(matriculaAluno, nomeAluno, emailAluno, codDisciplina, codTurma);

                try {
                    daoAluno.atualizar(alunoAtualizado);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel atualizar o aluno.\n"+ex);
                }

                break;

            case 3: // exclui
                System.out.print("Digite a matricula do aluno a ser excluido: ");
                matriculaAluno = Integer.parseInt(scanner.nextLine());

                try {
                    daoAluno.apagar(matriculaAluno);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel excluir o aluno.\n"+ex);
                }

                break;

            case 4: // lista
                Vector<Aluno> alunos = null;
                try {
                    alunos = daoAluno.buscarTodos();

                    for (int i = 0; i < alunos.size(); i++) {
                        StringBuilder stringAluno = new StringBuilder();
                        stringAluno.append(alunos.get(i).getMatricula());
                        stringAluno.append(" - ");
                        stringAluno.append(alunos.get(i).getNome());
                        stringAluno.append(" - ");
                        stringAluno.append(alunos.get(i).getEmail());
                        stringAluno.append(" - ");
                        stringAluno.append(alunos.get(i).getCodDisciplina());
                        stringAluno.append(" - ");
                        stringAluno.append(alunos.get(i).getCodTurma());
                        System.out.println(stringAluno.toString());
                    }
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel listar os alunos.\n"+ex);
                }

                break;
        }
    }
}
