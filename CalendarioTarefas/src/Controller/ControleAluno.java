package Controller;

import Model.Aluno;
import DAO.DAOAluno;
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
                
                matriculaAluno = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite a matricula do aluno: "));
                System.out.print("Digite o nome do aluno: ");
                nomeAluno = scanner.nextLine();
                System.out.print("Digite o email do aluno: ");
                emailAluno = scanner.nextLine();

                codDisciplina = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da disciplina: "));
                while(disciplinaok == false){
                    if(listDisciplinas.contains(codDisciplina)){
                        disciplinaok = true;
                    }
                    else{
                    System.out.println("Disciplina não existe, informe novamente!");
                    codDisciplina = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da disciplina: ")); 
                    }
                      
                }
                
                codTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da turma: "));
                while(turmaok == false){
                    if(listTurma.contains(codTurma)){
                        turmaok = true;
                    }
                    else{
                    System.out.println("Turma não existe, informe novamente!");
                    codTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da turma: "));
                    }
                      
                }

                Aluno novoAluno = new Aluno(matriculaAluno, nomeAluno, emailAluno, codDisciplina, codTurma);
                try {
                    daoAluno.insere(novoAluno);
                    System.out.println("Aluno inserido com sucesso.");
                } catch (SQLException ex) {                   
                    System.err.println("Erro: Nao foi possivel inserir o aluno.\n"+ex);
                }

                break;

            case 2: // atualiza
                boolean disciplinaok2 = false;
                boolean turmaok2 = false;
                
                matriculaAluno = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite a matricula do aluno a ser modificado: "));
                System.out.println("Digite o novo nome do aluno: ");
                nomeAluno = scanner.nextLine();
                System.out.println("Digite o novo email do aluno: ");
                emailAluno = scanner.nextLine();
                codDisciplina = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da disciplina: "));
                while(disciplinaok2 == false){
                    if(listDisciplinas.contains(codDisciplina)){
                        disciplinaok2 = true;
                    }
                    else{
                    System.out.println("Disciplina não existe, informe novamente!");
                    codDisciplina = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da disciplina: ")); 
                    }
                      
                }
                
                codTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da turma: "));
                while(turmaok2 == false){
                    if(listTurma.contains(codTurma)){
                        turmaok2 = true;
                    }
                    else{
                    System.out.println("Turma não existe, informe novamente!");
                    codTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da turma: "));
                    }
                      
                }

                Aluno alunoAtualizado = new Aluno(matriculaAluno, nomeAluno, emailAluno, codDisciplina, codTurma);

                try {
                    daoAluno.atualizar(alunoAtualizado);
                    System.out.println("Aluno atualizado com sucesso.");
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel atualizar o aluno.\n"+ex);
                }

                break;

            case 3: // exclui
                matriculaAluno = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite a matricula do aluno a ser excluido: "));

                try {
                    daoAluno.apagar(matriculaAluno);
                    System.out.println("Aluno excluido com sucesso.");
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
