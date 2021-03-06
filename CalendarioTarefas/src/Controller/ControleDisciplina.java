package Controller;

import Model.Disciplina;
import DAO.DAODisciplina;
import DAO.DAOTurma;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class ControleDisciplina {
    
    public static void controleDisciplina(int opcaoSubmenu) throws SQLException{
        Disciplina disciplina = new Disciplina();
        DAODisciplina daoDisciplina = new DAODisciplina();
        Scanner cod = new Scanner(System.in);
        Scanner nome = new Scanner(System.in);
        String nomeDisc = null;

        switch (opcaoSubmenu) {
            case 1: //insere
                
                int codigoDisc = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Informe o código da disciplina!"));
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
                DAOTurma daoturma = new DAOTurma();
                Vector<Integer> listTurma;
                boolean turmaok = false;
                
                System.out.println("Digite o código da disciplina a ser eliminada!");
                codigoDisc = cod.nextInt();
                listTurma = daoturma.buscarTurmaComDisciplina(codigoDisc);
                while(turmaok == false){
                    if(listTurma.contains(codigoDisc)){
                        System.out.println("Disciplina possui vinculo com Turma! Informe outro..");
                        codigoDisc = cod.nextInt();
                        
                    }
                    else{
                        turmaok = true;
                    }
                      
                }
                
                daoDisciplina.apagar(codigoDisc);
                break;

            case 4: // Lista
                Vector<Disciplina> dis = daoDisciplina.buscarTodos();
                for (int i = 0; i < dis.size(); i++) {
                    System.out.println(dis.get(i).getCodDisciplina() + " - " + dis.get(i).getNome());
                }
                break;

        }
    }
    
}
