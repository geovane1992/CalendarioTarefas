package Model;

/**
 *
 * @author Eric
 */
public class Aluno {

    private int matricula;
    private String nome;
    private String email;
    private int codDisciplina;
    private int codTurma;

    public Aluno() {
    }

    public Aluno(int matricula, String nome, String email, int codDisciplina, int codTurma) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.codDisciplina = codDisciplina;
        this.codTurma = codTurma;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }

}
