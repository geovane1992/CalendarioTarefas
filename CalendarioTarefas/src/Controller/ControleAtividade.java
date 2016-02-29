package Controller;

import Model.Atividade;
import DAO.DAOAtividade;
import DAO.DAOTurma;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;

public class ControleAtividade {

    public static void controleAtividade(int opcaoSubmenu) throws ParseException, SQLException {

        DAOAtividade daoAtividade = new DAOAtividade();
        DAOTurma daoturma = new DAOTurma();
        Scanner sc = new Scanner(System.in);
        int codAtividade;
        String nomeAtividade;
        String dataString;
        String observacaoAtividade;
        int codTurma = 0;
        Vector<Integer> listTurma;
        listTurma = daoturma.buscarTodosCodigos();

        switch (opcaoSubmenu) {
            case 1: //insere
                boolean turmaok = false;

                codAtividade = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da atividade: "));
                System.out.print("Digite o nome da atividade: ");
                nomeAtividade = sc.nextLine();

                System.out.println("Digite a data da atividade (dd/MM/aaaa): ");
                dataString = sc.nextLine();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date dta = new java.sql.Date(format.parse(dataString).getTime());

                System.out.print("Digite alguma observacao sobre a atividade: ");
                observacaoAtividade = sc.nextLine();

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

                Atividade novaAtividade = new Atividade(codAtividade, nomeAtividade, dta, observacaoAtividade, codTurma);

                try {
                    daoAtividade.insere(novaAtividade);
                    System.out.println("Atividade inserida com sucesso.");
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel inserir a atividade.\n" + ex);
                }

                break;

            case 2: // atualiza
                boolean turmaok2 = false;

                codAtividade = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da atividade a ser modificada: "));
                System.out.println("Digite o novo nome da atividade: ");
                nomeAtividade = sc.nextLine();

                System.out.println("Digite a nova data da atividade: ");
                dataString = sc.nextLine();
                SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date dta2 = new java.sql.Date(format2.parse(dataString).getTime());

                System.out.println("Digite uma nova observacao sobre a atividade: ");
                observacaoAtividade = sc.nextLine();
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

                Atividade atividadeAtualizada = new Atividade(codAtividade, nomeAtividade, dta2, observacaoAtividade, codTurma);

                try {
                    daoAtividade.atualizar(atividadeAtualizada);
                    System.out.println("Atividade atualizada com sucesso.");
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel atualizar a atividade.\n" + ex);
                }

                break;

            case 3: // exclui
                codAtividade = Integer.parseInt(ValidadorDeEntradas.validaSeENumero("Digite o codigo da atividade a ser excluida: "));

                try {
                    daoAtividade.apagar(codAtividade);
                    System.out.println("Atividade excluida com sucesso.");
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel excluir a atividade.\n" + ex);
                }

                break;

            case 4: // lista
                Vector<Atividade> atividades = null;
                try {
                    atividades = daoAtividade.buscarTodos();

                    for (Atividade atividade : atividades) {
                        StringBuilder stringAtividade = new StringBuilder();
                        stringAtividade.append(atividade.getCodAtividade());
                        stringAtividade.append(" - ");
                        stringAtividade.append(atividade.getNome());
                        stringAtividade.append(" - ");
                        stringAtividade.append(atividade.getData());
                        stringAtividade.append(" - ");
                        stringAtividade.append(atividade.getObservacao());
                        stringAtividade.append(" - ");
                        stringAtividade.append(atividade.getCodTurma());
                        System.out.println(stringAtividade.toString());
                    }
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel listar as atividades.\n" + ex);
                }
                
                break;
        }
    }
}
