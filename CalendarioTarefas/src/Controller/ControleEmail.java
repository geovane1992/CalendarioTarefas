package Controller;

import DAO.DAOAtividade;
import DAO.DAOEmail;
import DAO.DAOTurma;
import Model.Aluno;
import Model.Atividade;
import Model.Disciplina;
import Model.Turma;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import javax.mail.internet.InternetAddress;
import org.apache.commons.mail.SimpleEmail;


public class ControleEmail {
   
    
    public static void controleEmail(int opcaoSubmenu) throws SQLException, Exception{
        DAOAtividade daoatividade = new DAOAtividade();
        DAOTurma daoturma = new DAOTurma();
        Vector<Atividade> listAtividades = null;
        Vector<Turma> listTurma;
        Vector<Aluno> listAlunos;
        Vector<Atividade> listAtivid;
        Vector<Disciplina> listDisciplna;
        Vector<Integer> listCodTurma;
        Vector<Integer> listCodAtividade;
        String assunto = "";
        String conteudo = "";
        StringBuilder emails = new StringBuilder();
        boolean turmaok = false;
        boolean atividadeok = false;
        
        listCodTurma = daoturma.buscarTodosCodigos();
        String cdTurma = ValidadorDeEntradas.validaSeENumero("Informe o código da turma!:");
        while(turmaok == false){
                    if(listCodTurma.contains(Integer.parseInt(cdTurma))){
                        turmaok = true;
                    }
                    else{
                    System.out.println("Turma não exise!");
                    cdTurma = ValidadorDeEntradas.validaSeENumero("Informe o código da turma!:");
                    }
                      
        }
        
        switch(opcaoSubmenu){
            case 1:
               listAtividades = daoatividade.buscarTodasDaTurma(Integer.parseInt(cdTurma));
                    
               for(Atividade atividades : listAtividades){
                   StringBuilder stringAtividade = new StringBuilder();
                    stringAtividade.append(atividades.getCodAtividade());
                    stringAtividade.append(" - ");
                    stringAtividade.append(atividades.getNome());
                    stringAtividade.append(" - ");
                    stringAtividade.append(atividades.getData());
                    stringAtividade.append(" - ");
                    stringAtividade.append(atividades.getObservacao());
                    stringAtividade.append(" - ");
                    stringAtividade.append(atividades.getCodTurma());
                    System.out.println(stringAtividade.toString());
               }
                
            break;
                
            case 2:
                listCodAtividade = daoatividade.buscarTodosCodigos(Integer.parseInt(cdTurma));
                String cdAtividade = ValidadorDeEntradas.validaSeENumero("Informe o código da Atividade!:");
                while(atividadeok == false){
                    if(listCodAtividade.contains(Integer.parseInt(cdAtividade))){
                        atividadeok = true;
                    }
                    else{
                    System.out.println("Atividade não exise!");
                    cdAtividade = ValidadorDeEntradas.validaSeENumero("Informe o código da Atividade!:");
                    }
                      
                }
                
                listTurma = DAOEmail.buscarTurma(Integer.parseInt(cdTurma));
                listAlunos = DAOEmail.buscaAlunos(Integer.parseInt(cdTurma));
                listAtivid = DAOEmail.buscarAtividades(Integer.parseInt(cdTurma), Integer.parseInt(cdAtividade));
                listDisciplna = DAOEmail.buscarDsiciplina(Integer.parseInt(cdTurma));
                

                assunto = listAtivid.get(0).getNome() + " - " + listDisciplna.get(0).getNome();
                conteudo = "A data de realização será: " + listAtivid.get(0).getData() + "\n" + listAtivid.get(0).getObservacao();
  
                sendEmail(listTurma.get(0).getEmailProfessor(), listTurma.get(0).getEmailProfessor(), listAlunos, assunto, conteudo, opcaoSubmenu);
                
            break;
                
            case 3:

                listTurma = DAOEmail.buscarTurma(Integer.parseInt(cdTurma));
                listAlunos = DAOEmail.buscaAlunos(Integer.parseInt(cdTurma));
                listAtivid = DAOEmail.buscarAtividades(Integer.parseInt(cdTurma), 0);
                listDisciplna = DAOEmail.buscarDsiciplina(Integer.parseInt(cdTurma));
                
                
                assunto = listDisciplna.get(0).getNome();
                for(Atividade atividades : listAtivid){
                    conteudo = conteudo + atividades.getNome() + "\n A data de realização será: " + atividades.getData() + "\n" + atividades.getObservacao() + "\n\n";
                }                
  
                sendEmail(listTurma.get(0).getEmailProfessor(), listTurma.get(0).getEmailProfessor(), listAlunos, assunto, conteudo, opcaoSubmenu);
                
            break;
                
        }
    } 
    
        
    public static void sendEmail(String emailRemetente, String remetente, Vector<Aluno> listAlunos, String assunto, String conteudo, int opcao) throws Exception {
        
       // https://www.google.com/settings/security/lesssecureapps
        
        Collection<InternetAddress> recipient = new ArrayList<InternetAddress>();

        System.out.println("Enviando...");
        for (Aluno listAluno : listAlunos) {
           SimpleEmail email = new SimpleEmail(); 
           email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail.
           email.setSmtpPort(465); //Porta
           email.setFrom(remetente, "UFG Calendário de Tarefas"); // remetente 
           email.setSubject(assunto); // assunto do e-mail 
           email.setMsg(conteudo); //conteudo do e-mail 
           email.setSSL(true);
           email.setAuthentication("ufgmds@gmail.com", "ufgmds2016");
           email.addTo(listAluno.getEmail()); 
           email.send(); //envia o e-mail
        }
        
        System.out.println("E-mail enviado com sucesso! \n");
    }

    
}
