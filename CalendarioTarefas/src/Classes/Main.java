package Classes;

import Conexao.Conexao;
import DAO.DaoAluno;
import DAO.DaoDisciplina;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    
    public static int menuPrincipal(){
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
    
    public static int submenu(){
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

    public static void main(String[] args) {
       int opcaoMenu    = -1;
       int opcaoSubmenu = -1;
        DaoDisciplina daoDisciplina = new DaoDisciplina();
        Disciplina disciplina = new Disciplina();
       
       while(opcaoMenu != 0){ //Repetir menu
           opcaoMenu    = menuPrincipal();
           if(opcaoMenu >= 0 && opcaoMenu <= 6){

                while(opcaoSubmenu != 0){ //Repetir submenu
                    if(opcaoMenu != 0){
                         opcaoSubmenu = submenu();
                     }

                     switch(opcaoMenu){
                         case 1: //Curso
                         break;

                         case 2: //Aluno
                             DaoAluno daoAluno = new DaoAluno();
                             Scanner scanner = new Scanner(System.in);
                             int matriculaAluno;
                             String nomeAluno;
                             String emailAluno;
                             
                             switch(opcaoSubmenu) {
                                 case 1: //insere
                                     System.out.print("Informe a matricula do aluno: ");
                                     matriculaAluno = Integer.parseInt(scanner.nextLine());
                                     System.out.print("Informe o nome do aluno: ");
                                     nomeAluno = scanner.nextLine();
                                     System.out.print("Informe o email do aluno: ");
                                     emailAluno = scanner.nextLine();
                                     
                                     Aluno aluno = new Aluno(matriculaAluno, nomeAluno, emailAluno);
                                     daoAluno.insere(aluno);
                                 break;
                                     
                                     
                             }
                             
                         break;

                         case 3: // Disciplina
                             Scanner cod = new Scanner(System.in);
                             Scanner nome = new Scanner(System.in);
                             int codigoDisc;
                             String nomeDisc;

                             switch(opcaoSubmenu){
                                 case 1: //insere
                                     System.out.println("Infome o código da Discipliana!");
                                     codigoDisc = cod.nextInt();
                                     System.out.println("Infome o nome da Discipliana!");
                                     nomeDisc = nome.nextLine();

                                     disciplina.setCodDisciplina(codigoDisc);
                                     disciplina.setNome(nomeDisc);
                                     daoDisciplina.insere(disciplina);

                                 break;

                                 case 2: //Edita
                                     System.out.println("Digite o código da disciplina a ser modificada!");
                                     codigoDisc = cod.nextInt();
                                     System.out.println("Informe o novo nome para a disciplina!");
                                     nomeDisc = nome.nextLine();
                                     disciplina.setCodDisciplina(codigoDisc);
                                     disciplina.setNome(nomeDisc);
                                     daoDisciplina.atualizar(disciplina);
                                 break;

                                 case 3: //Exclui
                                     System.out.println("Digite o código da disciplina a ser eliminada!");
                                     codigoDisc = cod.nextInt();
                                     daoDisciplina.apagar(codigoDisc);
                                 break;

                                 case 4: // Lista
                                     Vector<Disciplina> dis = daoDisciplina.buscarTodos();
                                     for(int i = 0; i < dis.size(); i ++){
                                          System.out.println(dis.get(i).getCodDisciplina() + " - " + dis.get(i).getNome());
                                     }
                                 break;

                                 default:
                                     System.out.println("Informe uma opção válida!");
                                 break;
                             }
                         break;

                         case 4: // Atividade
                         break;

                         case 5: // Turma
                         break;

                         case 6: // Importar Arquivo
                         break;

                         default:
                             System.out.println("Informe uma opção válida!");
                         break;

                     }
                }
           }
           else{
               System.out.println("Informe uma opção válida!");
           }
           
       }


    }
    
}
