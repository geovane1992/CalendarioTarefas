package Controller;

import DAO.DAODisciplina;
import Model.Disciplina;
import Model.Turma;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static int menuPrincipal() {
        int opcaoEscolhida = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("######## MENU PRINCIPAL ######## \n"
                + "1 - Cadastrar Curso               \n"
                + "2 - Cadastrar Aluno               \n"
                + "3 - Cadastrar Disciplina          \n"
                + "4 - Cadastrar Atividade           \n"
                + "5 - Cadastrar Turma               \n"
                + "6 - Importar CSV de Alunos        \n"
                + "0 - Sair                        \n\n"
                + "Escolha uma das opções acima...   \n"
        );

        opcaoEscolhida = sc.nextInt();

        return opcaoEscolhida;
    }

    public static int submenu() {
        int opcaoEscolhida = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("######## SUBMENU ########     \n"
                + "1 - Inserir                    \n"
                + "2 - Editar                     \n"
                + "3 - Excluir                    \n"
                + "4 - Listar                     \n"
                + "0 - Sair                     \n\n"
                + "Escolha uma das opções acima...\n"
        );

        opcaoEscolhida = sc.nextInt();

        return opcaoEscolhida;
    }

    public static void main(String[] args) throws ParseException {
        int opcaoMenu = -1;
        int opcaoSubmenu = -1;
        DAODisciplina daoDisciplina = new DAODisciplina();
        Disciplina disciplina = new Disciplina();
        Turma turma = new Turma();

        while (opcaoMenu != 0) { //Repetir menu
            opcaoMenu = menuPrincipal();
            opcaoSubmenu = -1;
            if (opcaoMenu >= 0 && opcaoMenu <= 6) {

                if (opcaoMenu != 0) {
                    while (opcaoSubmenu != 0) { //Repetir submenu
                        opcaoSubmenu = submenu();
                        if (opcaoSubmenu < 0 || opcaoSubmenu > 4) {
                            System.out.println("Informe uma opção válida!");
                        }
                        else{

                            switch (opcaoMenu) {
                                case 1: //Curso
                                    Controller.ControleCurso.controleCurso(opcaoSubmenu);
                                break;

                                case 2: //Aluno
                                    Controller.ControleAluno.controleAluno(opcaoSubmenu);
                                break;

                                case 3: // Disciplina
                                    Controller.ControleDisciplina.controleDisciplina(opcaoSubmenu);
                                break;

                                case 4: // Atividade
                                    Controller.ControleAtividade.controleAtividade(opcaoSubmenu);
                                break;

                                case 5: // Turma
                                    Controller.ControleTurma.controleTurma(opcaoSubmenu);
                                break;

                                case 6: // Importar Arquivo
                                break;

                            }
                        }
                    }                  
                }

            } else {
                System.out.println("Informe uma opção válida!");
            }

        }

    }

}
