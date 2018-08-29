package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TabelaProjetos {
    private IntegerProperty Id;
    public void setId(Integer id){
        IdProperty().set(id);
    }
    public Integer getId(){
        return IdProperty().get();
    }
    public IntegerProperty IdProperty(){
        if(Id == null){
            Id = new SimpleIntegerProperty(this,"Id");
        }
        return Id;
    }
    private StringProperty Proj;
    public void setProj(String cpf){
        ProjProperty().set(cpf);
    }
    public String getProj(){
        return ProjProperty().get();
    }
    public StringProperty ProjProperty(){
        if(Proj == null){
            Proj = new SimpleStringProperty(this,"Cpf");
        }
        return Proj;
    }
    private StringProperty NomeC;
    public void setNomeC(String nome){
        NomeCProperty().set(nome);
    }
    public String getNomeC(){
        return NomeCProperty().get();
    }

    public StringProperty NomeCProperty() {
        if(NomeC == null){
            NomeC = new SimpleStringProperty(this,"Nome");
        }
        return NomeC;
    }
}
