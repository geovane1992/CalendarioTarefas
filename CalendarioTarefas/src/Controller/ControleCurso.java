package Controller;

import Model.Curso;
import DAO.DAOCurso;
import java.util.Scanner;
import java.util.Vector;

public class ControleCurso {
    
    public static void controleCurso(int opcaoSubmenu){
    
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
                daoCurso.insere(curso);

                break;

            case 2: //Edita
                System.out.println("Digite o código do Curso a ser modificado!");
                codigoCurso = entradaCodigo.nextInt();
                System.out.println("Informe o novo nome para a disciplina!");
                nomeCurso = entradaNome.nextLine();

                curso.setCodCurso(codigoCurso);
                curso.setNome(nomeCurso);
                daoCurso.atualizar(curso);
                break;

            case 3: //Exclui
                System.out.println("Digite o código do Curso a ser eliminado!");
                codigoCurso = entradaCodigo.nextInt();
                daoCurso.apagar(codigoCurso);
                break;

            case 4: // Lista
                Vector<Curso> cursoPreenchido = daoCurso.buscarTodos();
                for (int i = 0; i < cursoPreenchido.size(); i++) {
                    System.out.println(cursoPreenchido.get(i).getCodCurso() + " - " + cursoPreenchido.get(i).getNome());
                }
                break;

        }
    }
    
}
