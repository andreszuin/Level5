package Model;

import java.sql.Date;

public class Membro {
    private String nome;
    private String cpf;
    private String rg;
    private String oe;
    private Date datae;
    private String nac;
    private String ecivil;
    private String prof;
    private String end;
    private String cep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOe() {
        return oe;
    }

    public void setOe(String oe) {
        this.oe = oe;
    }

    public java.time.LocalDate getDatae() {
        return datae.toLocalDate();
    }

    public void setDatae(java.time.LocalDate datae) {
        this.datae = java.sql.Date.valueOf(datae);
    }

    public String getNac() {
        return nac;
    }

    public void setNac(String nac) {
        this.nac = nac;
    }

    public String getEcivil() {
        return ecivil;
    }

    public void setEcivil(String ecivil) {
        this.ecivil = ecivil;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
