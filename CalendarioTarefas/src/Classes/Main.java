package Classes;

import Conexao.Conexao;
import java.util.Scanner;

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
       
       while(opcaoMenu != 0){
           opcaoMenu    = menuPrincipal();
           if(opcaoMenu != 0){
                opcaoSubmenu = submenu();
           }
           
           switch(opcaoMenu){
               case 1: //Curso
               break;
                   
               case 2: //Aluno
               break;
                   
               case 3: // Disciplina
                   switch(opcaoSubmenu){
                       case 1:
                           
                       break;
                           
                       case 2:
                       break;
                           
                       case 3:
                       break;
                           
                       case 4:
                       break;
                   }
               break;
                   
               case 4: // Atividade
               break;
                   
               case 5: // Turma
               break;
                   
               case 6: // Importar Arquivo
               break;
                   
           }
           
       }


    }
    
}
