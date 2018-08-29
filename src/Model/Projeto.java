package Model;

import java.sql.Date;

public class Projeto {
    private Integer id;
    private String projeto;
    private String nomeC;
    private Double valor;
    private Date datai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public java.time.LocalDate getDatai() {
        return datai.toLocalDate();
    }

    public void setDatai(java.time.LocalDate datai) {
        this.datai = java.sql.Date.valueOf(datai);
    }
}
