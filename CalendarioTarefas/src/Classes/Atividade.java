package Classes;

import java.util.Calendar;

/**
 *
 * @author Eric
 */
public class Atividade {

    private int codAtividade;
    private String nome;
    private Calendar data;
    private String observacao;

    public Atividade() {
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
