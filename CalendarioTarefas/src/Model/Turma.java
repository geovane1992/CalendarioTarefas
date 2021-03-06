package Model;

/**
 *
 * @author Henrique
 */
public class Turma {

    private int codigoTurma;
    private int codigoCurso;
    private int codigoDisciplina;
    private String periodo;
    private String nomeProfessor;
    private String emailProfessor;

    public Turma() {
        //Sonar
    }

    public Turma(int codigoTurma, int codigoCurso, int codigoDsiciplina, String periodo, String nomeProfessor, String emailProfessor) {
        this.codigoTurma = codigoTurma;
        this.codigoCurso = codigoCurso;
        this.codigoDisciplina = codigoDsiciplina;
        this.periodo = periodo;
        this.nomeProfessor = nomeProfessor;
        this.emailProfessor = emailProfessor;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }
    
    public String getEmailProfessor() {
        return emailProfessor;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public void setCodigoDisciplina(int codigoDsiciplina) {
        this.codigoDisciplina = codigoDsiciplina;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
    
    public void setEmailProfessor(String emailProfessor){
        this.emailProfessor = emailProfessor;
    }
}
