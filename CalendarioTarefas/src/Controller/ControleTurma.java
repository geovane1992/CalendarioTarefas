package Controller;

import Model.Turma;
import DAO.DAOTurma;
import java.util.Scanner;
import java.util.Vector;

public class ControleTurma {
    
    public static void controleTurma(int opcaoSubmenu){
        Turma turma = new Turma();
        DAOTurma daoTurma = new DAOTurma();
        Scanner entradaDadosInt = new Scanner(System.in);
        Scanner entradaDadosString = new Scanner(System.in);
        int codigoTurma;
        int codigoTurmaNova;
        int codigoCursoTurma;
        int codigoAtividade;
        int codigoDisciplina;
        String periodo;
        String nomeProfessor;

        switch (opcaoSubmenu) {
            case 1: //insere
                System.out.println("Infome o código da Turma!");
                codigoTurma = entradaDadosInt.nextInt();
                System.out.println("Infome o periodo da Turma!");
                periodo = entradaDadosString.nextLine();
                System.out.println("Infome o nome do Professor!");
                nomeProfessor = entradaDadosString.nextLine();
                System.out.println("Infome o código do Curso!");
                codigoCursoTurma = entradaDadosInt.nextInt();
                System.out.println("Infome o código da Atividade!");
                codigoAtividade = entradaDadosInt.nextInt();
                System.out.println("Infome o código da Disciplina!");
                codigoDisciplina = entradaDadosInt.nextInt();

                turma.setCodigoTurma(codigoTurma);
                turma.setPeriodo(periodo);
                turma.setNomeProfessor(nomeProfessor);
                turma.setCodigoCurso(codigoCursoTurma);
                turma.setCodigoAtividade(codigoAtividade);
                turma.setCodigoDisciplina(codigoDisciplina);
                daoTurma.insere(turma);

                break;

            case 2: //Edita
                System.out.println("Digite o código da turma a ser modificada!");
                codigoTurma = entradaDadosInt.nextInt();

                System.out.println("Informe o novo código da turma!");
                codigoTurmaNova = entradaDadosInt.nextInt();
                System.out.println("Infome o novo código da Turma!");
                periodo = entradaDadosString.nextLine();
                System.out.println("Infome o novo nome do Professor!");
                nomeProfessor = entradaDadosString.nextLine();
                System.out.println("Infome o novo código do Curso!");
                codigoCursoTurma = entradaDadosInt.nextInt();
                System.out.println("Infome o novo código da Atividade!");
                codigoAtividade = entradaDadosInt.nextInt();
                System.out.println("Infome o novo código da Disciplina!");
                codigoDisciplina = entradaDadosInt.nextInt();

                turma.setCodigoTurma(codigoTurmaNova);
                turma.setPeriodo(periodo);
                turma.setNomeProfessor(nomeProfessor);
                turma.setCodigoCurso(codigoCursoTurma);
                turma.setCodigoAtividade(codigoAtividade);
                turma.setCodigoDisciplina(codigoDisciplina);
                daoTurma.atualizar(turma);
                break;

            case 3: //Exclui
                System.out.println("Digite o código da turma a ser eliminada!");
                codigoTurma = entradaDadosInt.nextInt();
                daoTurma.apagar(codigoTurma);
                break;

            case 4: // Lista
                Vector<Turma> turmaPreenchida = daoTurma.buscarTodos();
                for (int i = 0; i < turmaPreenchida.size(); i++) {
                    System.out.println(turmaPreenchida.get(i).getCodigoTurma()
                            + " - " + turmaPreenchida.get(i).getPeriodo()
                            + " - " + turmaPreenchida.get(i).getNomeProfessor()
                            + " - " + turmaPreenchida.get(i).getCodigoCurso()
                            + " - " + turmaPreenchida.get(i).getCodigoAtividade()
                            + " - " + turmaPreenchida.get(i).getCodigoDisciplina());
                }
                break;

        }
        
    }
    
}
