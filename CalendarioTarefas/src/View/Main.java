package View;

import Controller.ControleAluno;
import Controller.ControleAtividade;
import Controller.ControleCSV;
import Controller.ControleCurso;
import Controller.ControleDisciplina;
import Controller.ControleEmail;
import Controller.ControleTurma;
import java.sql.SQLException;
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
                + "7 - Consultar / Enviar Atividades \n"
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
    
    public static int atividades() {
        int opcaoEscolhida = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("######## SUBMENU ########     \n"
                + "1 - Listar Atividades          \n"
                + "2 - Enviar Atividade           \n"
                + "3 - Enviar Lista Atividades    \n"
                + "0 - Sair                     \n\n"
                + "Escolha uma das opções acima...\n"
        );

        opcaoEscolhida = sc.nextInt();

        return opcaoEscolhida;
    }

    public static void main(String[] args) throws ParseException, SQLException, Exception {
        int opcaoMenu = -1;
        int opcaoSubmenu = -1;
        int atividades    = -1;

        while (opcaoMenu != 0) { //Repetir menu
            opcaoMenu = menuPrincipal();
            opcaoSubmenu = -1;
            atividades = -1;
            if (opcaoMenu >= 0 && opcaoMenu <= 7) {

                if (opcaoMenu != 0 && opcaoMenu != 6) {
                    while (opcaoSubmenu != 0 && atividades != 0) { //Repetir submenu
                        if(opcaoMenu != 7){
                            opcaoSubmenu = submenu();
                        }
                        else{
                            atividades = atividades();
                        }
                        if (opcaoSubmenu < -1 || opcaoSubmenu > 4 || atividades < -1 || atividades > 3) {
                            System.out.println("Informe uma opção válida!");
                        }
                        else{

                            switch (opcaoMenu) {
                                case 1: //Curso
                                    ControleCurso.controleCurso(opcaoSubmenu);
                                break;

                                case 2: //Aluno
                                    ControleAluno.controleAluno(opcaoSubmenu);
                                break;

                                case 3: // Disciplina
                                    ControleDisciplina.controleDisciplina(opcaoSubmenu);
                                break;

                                case 4: // Atividade
                                    ControleAtividade.controleAtividade(opcaoSubmenu);
                                break;

                                case 5: // Turma
                                    ControleTurma.controleTurma(opcaoSubmenu);
                                break;

                                case 6: // Importar Arquivo
                                    ControleCSV.controleCSV();
                                break;
                                
                                case 7:
                                    ControleEmail.controleEmail(atividades);
                                break;

                            }
                        }
                    }                  
                } else if (opcaoMenu == 6) {
                    ControleCSV.controleCSV();
                }

            } else {
                System.out.println("Informe uma opção válida!");
            }

        }

    }

}
