/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Henrique
 */
public class Turma {
    private int codigoTurma;
    private int codigoCurso;
    private int codigoAtividade;
    private int codigoDisciplina;
    private String periodo;
    private String nomeProfessor;
    
    public Turma() {
    }
    
    public Turma(int codigoTurma, int codigoCurso, int codigoAtividade, int codigoDsiciplina, String periodo, String nomeProfessor) {
        this.codigoTurma = codigoTurma;
        this.codigoCurso = codigoCurso;
        this.codigoAtividade = codigoAtividade;
        this.codigoDisciplina = codigoDsiciplina;
        this.periodo = periodo;
        this.nomeProfessor = nomeProfessor;
    }
    
    public int getCodigoTurma() {
        return codigoTurma;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public int getCodigoAtividade() {
        return codigoAtividade;
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
    
    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public void setCodigoAtividade(int codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
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
}
