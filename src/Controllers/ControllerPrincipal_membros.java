package Controllers;

import Model.Membro;
import Model.TabelaMembros;
import Teste.Conecta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ControllerPrincipal_membros {
    ObservableList<String> estado = FXCollections.observableArrayList("Solteiro(a)","Casado(a)","Divorciado(a)");
    @FXML//pane
    public Pane add_membros;
    public Pane change_membros;
    public Pane delete_membros;
    public Pane view_membros;
    @FXML//inputs
    public ChoiceBox estadoField;
    public TextField nomeField;
    public TextField cpfField;
    public TextField rgField;
    public TextField oeField;
    public TextField nacField;
    public TextField proField;
    public TextField endField;
    public TextField cepField;
    public DatePicker dateField;
    public ChoiceBox estadoField1;
    public TextField nomeField1;
    public TextField cpfField1;
    public TextField rgField1;
    public TextField oeField1;
    public TextField nacField1;
    public TextField proField1;
    public TextField endField1;
    public TextField cepField1;
    public DatePicker dateField1;
    public TextField estadoField2;
    public TextField nomeField2;
    public TextField cpfField2;
    public TextField rgField2;
    public TextField oeField2;
    public TextField nacField2;
    public TextField proField2;
    public TextField endField2;
    public TextField cepField2;
    public TextField dateField2;
    public TextField cpfField3;
    @FXML
    private TableView<TabelaMembros> tabela_membros;
    public TableColumn<TabelaMembros,String>colNome;
    public TableColumn<TabelaMembros,String>colCPF;
    java.time.LocalDate setDate;
    java.sql.Date date;
    //objects
    Conecta conex = new Conecta();
    Membro membro = new Membro();
    ControllerMembro control = new ControllerMembro();

    public void initialize(){
        atuTabela();
    }

    public void atuTabela(){
        colNome.setCellValueFactory(new PropertyValueFactory<TabelaMembros,String>("nome"));
        colCPF.setCellValueFactory(new PropertyValueFactory<TabelaMembros,String>("cpf"));
        tabela_membros.getItems().setAll(lista());
    }

    private List<TabelaMembros> lista(){
        conex.conexao();
        List membros = new LinkedList();
        try{
            conex.executa("select * from membro");
            while(conex.rs.next()){
                String nome = conex.rs.getString(1);
                String cpf = conex.rs.getString(2);
                TabelaMembros tabm = new TabelaMembros();
                tabm.setCpf(cpf);
                tabm.setNome(nome);
                membros.add(tabm);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro na coisinha de adicionar a tabela\nerro:"+ex);
        }
        conex.desconnect();
        return membros;
    }

    //add membros
    public void OpenAdd_membros(){
        delete_membros.setVisible(false);
        change_membros.setVisible(false);
        view_membros.setVisible(false);
        add_membros.setVisible(true);
        estadoField.setValue("Solteiro(a)");
        estadoField.setItems(estado);
    }
    public void save() {
        membro.setNome(nomeField.getText());
        membro.setCpf(cpfField.getText());
        membro.setRg(rgField.getText());
        membro.setOe(oeField.getText());
        membro.setNac(nacField.getText());
        membro.setProf(proField.getText());
        membro.setEnd(endField.getText());
        membro.setCep(cepField.getText());
        membro.setEcivil(estadoField.getValue().toString());
        membro.setDatae(dateField.getValue());
        control.InserirMembro(membro);
        nomeField.setText(null);
        cpfField.setText(null);
        rgField.setText(null);
        oeField.setText(null);
        nacField.setText(null);
        proField.setText(null);
        endField.setText(null);
        cepField.setText(null);
        estadoField.setValue("Solteiro(a)");
        dateField.setValue(null);
        //
        atuTabela();
    }
    //change membros
    public void OpenChange_membros(){
        delete_membros.setVisible(false);
        add_membros.setVisible(false);
        view_membros.setVisible(false);
        change_membros.setVisible(true);
        estadoField1.setItems(estado);
    }
    public void search(){
        conex.conexao();
        estadoField1.setDisable(false);
        nomeField1.setDisable(false);
        rgField1.setDisable(false);
        oeField1.setDisable(false);
        nacField1.setDisable(false);
        proField1.setDisable(false);
        endField1.setDisable(false);
        cepField1.setDisable(false);
        dateField1.setDisable(false);
        try {
            conex.executa("select * from membro where cpf='" + cpfField1.getText() + "'");
            conex.rs.first();
            nomeField1.setText(conex.rs.getString("nome"));
            rgField1.setText(conex.rs.getString("rg"));
            oeField1.setText(conex.rs.getString("oexpeditor"));
            nacField1.setText(conex.rs.getString("nacionalidade"));
            proField1.setText(conex.rs.getString("profissao"));
            endField1.setText(conex.rs.getString("endereco"));
            cepField1.setText(conex.rs.getString("cep"));
            estadoField1.setValue(conex.rs.getString("ecivil"));
            date = conex.rs.getDate("dataentrada");
            setDate = date.toLocalDate();
            dateField1.setValue(setDate);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao buscar os dados\nerro:"+ex);
        }
        conex.desconnect();
    }
    public void alterar(){
        membro.setNome(nomeField1.getText());
        membro.setCpf(cpfField1.getText());
        membro.setRg(rgField1.getText());
        membro.setOe(oeField1.getText());
        membro.setNac(nacField1.getText());
        membro.setProf(proField1.getText());
        membro.setEnd(endField1.getText());
        membro.setCep(cepField1.getText());
        membro.setEcivil(estadoField1.getValue().toString());
        membro.setDatae(dateField1.getValue());
        control.AlteraMembro(membro);
        nomeField1.setText(null);
        cpfField1.setText(null);
        rgField1.setText(null);
        oeField1.setText(null);
        nacField1.setText(null);
        proField1.setText(null);
        endField1.setText(null);
        cepField1.setText(null);
        estadoField1.setValue("Solteiro(a)");
        dateField1.setValue(null);
        nomeField1.setDisable(true);
        rgField1.setDisable(true);
        oeField1.setDisable(true);
        nacField1.setDisable(true);
        proField1.setDisable(true);
        endField1.setDisable(true);
        cepField1.setDisable(true);
        estadoField1.setDisable(true);
        dateField1.setDisable(true);
        //
        atuTabela();
    }
    //delete membros
    public void OpenRemove_membros(){
        view_membros.setVisible(false);
        add_membros.setVisible(false);
        change_membros.setVisible(false);
        delete_membros.setVisible(true);
    }
    public void delete(){
        membro.setCpf(cpfField3.getText());
        control.ExcluirMembro(membro);
        cpfField3.setText(null);
        //
        atuTabela();
    }
    //view membros
    public void OpenView_membros(){
        add_membros.setVisible(false);
        change_membros.setVisible(false);
        delete_membros.setVisible(false);
        view_membros.setVisible(true);
    }
    public void searchview(){
        conex.conexao();
        try {
            conex.executa("select * from membro where cpf='" + cpfField2.getText() + "'");
            conex.rs.first();
            nomeField2.setText(conex.rs.getString("nome"));
            rgField2.setText(conex.rs.getString("rg"));
            oeField2.setText(conex.rs.getString("oexpeditor"));
            nacField2.setText(conex.rs.getString("nacionalidade"));
            proField2.setText(conex.rs.getString("profissao"));
            endField2.setText(conex.rs.getString("endereco"));
            cepField2.setText(conex.rs.getString("cep"));
            estadoField2.setText(conex.rs.getString("ecivil"));
            date = conex.rs.getDate("dataentrada");
            setDate = date.toLocalDate();
            dateField2.setText(setDate.toString());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao buscar os dados\nerro:"+ex);
        }
        conex.desconnect();
    }
}
