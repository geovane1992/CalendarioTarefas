package Controller;

import DAO.DAOCurso;
import DAO.DAODisciplina;
import Model.Turma;
import DAO.DAOTurma;
import Model.Curso;
import Model.Disciplina;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class ControleTurma {
    
    public static void controleTurma(int opcaoSubmenu) throws SQLException{
        Turma turma = new Turma();
        DAOTurma daoTurma = new DAOTurma();
        DAODisciplina daodisciplina = new DAODisciplina();
        DAOCurso daocurso = new DAOCurso();
        Scanner entradaDadosInt = new Scanner(System.in);
        Scanner entradaDadosString = new Scanner(System.in);
        int codigoTurma;
        int codigoTurmaNova;
        int codigoCursoTurma;
        int codigoAtividade;
        int codigoDisciplina = 0;
        String periodo;
        String nomeProfessor;
        String emailProfessor;
        Vector<Integer> listDisciplinas;
        Vector<Integer> listCursos;
        
        listDisciplinas = daodisciplina.buscarTodosCodigo();
        listCursos = daocurso.buscarTodosCodigo();

        switch (opcaoSubmenu) {
            case 1: //insere
                boolean disciplinaok = false;
                boolean cursook = false;

                codigoTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Informe o código da Turma!"));
                System.out.println("Infome o periodo da Turma!");
                periodo = entradaDadosString.nextLine();
                System.out.println("Infome o nome do Professor!");
                nomeProfessor = entradaDadosString.nextLine();
                System.out.println("Infome o email do Professor!");
                emailProfessor = entradaDadosString.nextLine();
                
                codigoCursoTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Informe o código do Curso!"));
                while(cursook == false){
                    if(listCursos.contains(codigoCursoTurma)){
                        cursook = true;
                    }
                    else{
                    codigoCursoTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Curso nao exise informe novamente!"));   
                    }
                      
                }
                
                codigoDisciplina = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Infome o codigo da Disciplina!"));
                while(disciplinaok == false){
                    if(listDisciplinas.contains(codigoDisciplina)){
                        disciplinaok = true;
                    }
                    else{
                    codigoDisciplina = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Disciplina não exise informe novamente!"));  
                    }
                      
                }
  
                turma.setCodigoTurma(codigoTurma);
                turma.setPeriodo(periodo);
                turma.setNomeProfessor(nomeProfessor);
                turma.setCodigoCurso(codigoCursoTurma);
                turma.setCodigoDisciplina(codigoDisciplina);
                turma.setEmailProfessor(emailProfessor);
                
                try {
                     daoTurma.insere(turma);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel inserir a turma.\n" + ex);
                }

                break;

            case 2: //Edita
                boolean disciplinaok2 = false;
                boolean cursook2 = false;
                
                codigoTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da turma a ser modificada!"));  

                System.out.println("Infome o novo periodo da turma!");
                periodo = entradaDadosString.nextLine();
                System.out.println("Infome o novo nome do Professor!");
                nomeProfessor = entradaDadosString.nextLine();
                System.out.println("Infome o novo email do Professor!");
                emailProfessor = entradaDadosString.nextLine();
                codigoCursoTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Infome o novo Codigo!"));  
                while(cursook2 == false){
                    if(listCursos.contains(codigoCursoTurma)){
                        cursook2 = true;
                    }
                    else{
                    codigoCursoTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Codigo nao exise informe novamente!"));  
                    }
                      
                }
                
                codigoDisciplina = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Infome o novo codigo da Disciplina!"));  
                while(disciplinaok2 == false){
                    if(listDisciplinas.contains(codigoDisciplina)){
                        disciplinaok2 = true;
                    }
                    else{
                    codigoDisciplina =  Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Disciplina nao exise informe o codigo novamente!"));   
                    }
                      
                }

                turma.setCodigoTurma(codigoTurma);
                turma.setPeriodo(periodo);
                turma.setNomeProfessor(nomeProfessor);
                turma.setCodigoCurso(codigoCursoTurma);
                turma.setCodigoDisciplina(codigoDisciplina);
                turma.setEmailProfessor(emailProfessor);
                
                try {
                    daoTurma.atualizar(turma);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel atualizar a turma.\n" + ex);
                }
                break;

            case 3: //Exclui
                codigoTurma = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da turma a ser eliminada!"));   
                
                try {
                     daoTurma.apagar(codigoTurma);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel excluir a turma.\n" + ex);
                }
                break;

            case 4: // Lista
                
                try {
                    Vector<Turma> turmaPreenchida = daoTurma.buscarTodos();
                    for (int i = 0; i < turmaPreenchida.size(); i++) {
                    System.out.println(turmaPreenchida.get(i).getCodigoTurma()
                            + " - " + turmaPreenchida.get(i).getPeriodo()
                            + " - " + turmaPreenchida.get(i).getNomeProfessor()
                            + " - " + turmaPreenchida.get(i).getCodigoCurso()
                            + " - " + turmaPreenchida.get(i).getCodigoDisciplina()
                            + " - " + turmaPreenchida.get(i).getEmailProfessor());
                }
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel listar a turma.\n" + ex);
                }
                break;
        }
        
    }
    
}
