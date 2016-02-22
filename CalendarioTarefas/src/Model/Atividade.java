package Model;

import java.util.Date;

/**
 *
 * @author Eric
 */
public class Atividade {

    private int codAtividade;
    private String nome;
    private Date data;
    private String observacao;
    private int codTurma;

    public Atividade() {
    }

    public Atividade(int codAtividade, String nome, Date data, String observacao, int codTurma) {
        this.codAtividade = codAtividade;
        this.nome = nome;
        this.data = data;
        this.observacao = observacao;
        this.codTurma = codTurma;
    }

    public int getCodAtividade() {
        return codAtividade;
    }

    public void setCodAtividade(int codAtividade) {
        this.codAtividade = codAtividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }
    
    
    
}
