package Controller;

import Model.Curso;
import DAO.DAOCurso;
import DAO.DAOTurma;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class ControleCurso {
    
    public static void controleCurso(int opcaoSubmenu) throws SQLException{
    
        DAOCurso daoCurso = new DAOCurso();
        Curso curso = new Curso();
        Scanner entradaCodigo = new Scanner(System.in);
        Scanner entradaNome = new Scanner(System.in);
        int codigoCurso;
        String nomeCurso;

        switch (opcaoSubmenu) {
            case 1: //insere
                System.out.println("Infome o código do Curso!");
                codigoCurso = entradaCodigo.nextInt();
                System.out.println("Infome o nome do Curso!");
                nomeCurso = entradaNome.nextLine();

                curso.setCodCurso(codigoCurso);
                curso.setNome(nomeCurso);
        
                try {
                    daoCurso.insere(curso);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel inserir o curso.\n" + ex);
                }
                break;

            case 2: //Edita
                System.out.println("Digite o código do Curso a ser modificado!");
                codigoCurso = entradaCodigo.nextInt();
                System.out.println("Informe o novo nome para a disciplina!");
                nomeCurso = entradaNome.nextLine();

                curso.setCodCurso(codigoCurso);
                curso.setNome(nomeCurso);
                
                try {
                    daoCurso.atualizar(curso);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel atualizar o curso.\n" + ex);
                }
                break;

            case 3: //Exclui
                DAOTurma daoturma = new DAOTurma();
                Vector<Integer> listTurma;
                boolean turmaok = false;
                
                System.out.println("Digite o código do Curso a ser eliminado!");
                codigoCurso = entradaCodigo.nextInt();
                listTurma = daoturma.buscarTurmaComCurso(codigoCurso);
                while(turmaok == false){
                    if(listTurma.contains(codigoCurso)){
                        System.out.println("Curso possui vinculo com Turma! Informe outro..");
                        codigoCurso = entradaCodigo.nextInt();
                        
                    }
                    else{
                        turmaok = true;
                    }
                      
                }
                

                try {
                     daoCurso.apagar(codigoCurso);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel excluir o curso.\n" + ex);
                }
                break;

            case 4: // Lista
                try {
                    Vector<Curso> cursoPreenchido = daoCurso.buscarTodos();
                for (int i = 0; i < cursoPreenchido.size(); i++) {
                    System.out.println(cursoPreenchido.get(i).getCodCurso() + " - " + cursoPreenchido.get(i).getNome());
                }
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel listar as atividades.\n" + ex);
                }
                break;

        }
    }
    
}
