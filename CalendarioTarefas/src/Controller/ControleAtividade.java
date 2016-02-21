package Controller;

import Model.Atividade;
import DAO.DAOAtividade;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class ControleAtividade {

    public static void controleAtividade(int opcaoSubmenu) throws ParseException {

        DAOAtividade daoAtividade = new DAOAtividade();
        Scanner sc = new Scanner(System.in);
        int codAtividade;
        String nomeAtividade;
        String dataString;
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada;
        String observacaoAtividade;
        int codTurma = 0;

        switch (opcaoSubmenu) {
            case 1: //insere
                System.out.print("Digite o codigo da atividade: ");
                codAtividade = Integer.parseInt(sc.nextLine());
                System.out.print("Digite o nome da atividade: ");
                nomeAtividade = sc.nextLine();

                System.out.println("Digite a data da atividade: ");
                dataString = sc.nextLine();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date dta = new java.sql.Date(format.parse(dataString).getTime());

                System.out.print("Digite alguma observacao sobre a atividade: ");
                observacaoAtividade = sc.nextLine();
                System.out.print("Digite o código da turma: ");
                codTurma = sc.nextInt();

                Atividade novaAtividade = new Atividade(codAtividade, nomeAtividade, dta, observacaoAtividade, codTurma);

                try {
                    daoAtividade.insere(novaAtividade);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel inserir a atividade.\n" + ex);
                }

                break;

            case 2: // atualiza
                System.out.print("Digite o codigo da atividade a ser modificada: ");
                codAtividade = Integer.parseInt(sc.nextLine());
                System.out.println("Digite o novo nome da atividade: ");
                nomeAtividade = sc.nextLine();

                System.out.println("Digite a nova data da atividade: ");
                dataString = sc.nextLine();
                SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date dta2 = new java.sql.Date(format2.parse(dataString).getTime());

                System.out.println("Digite uma nova observacao sobre a atividade: ");
                observacaoAtividade = sc.nextLine();
                System.out.print("Digite o código da turma: ");
                codTurma = Integer.parseInt(sc.nextLine());

                Atividade atividadeAtualizada = new Atividade(codAtividade, nomeAtividade, dta2, observacaoAtividade, codTurma);

                try {
                    daoAtividade.atualizar(atividadeAtualizada);
                } catch (SQLException ex) {
                    System.err.println("Erro: Nao foi possivel atualizar a atividade.\n" + ex);
                }

                break;

            case 3: // exclui
                System.out.print("Digite o codigo da atividade a ser excluida: ");
                codAtividade = Integer.parseInt(sc.nextLine());

                try {
                    daoAtividade.apagar(codAtividade);
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
