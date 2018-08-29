package Controllers;

import Model.Projeto;
import Model.TabelaProjetos;
import Teste.Conecta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ControllerPrincipal_proj {
    @FXML//panes
    public Pane add_projetos;
    public Pane change_projetos;
    public Pane delete_projetos;
    public Pane view_projetos;
    @FXML//inputs
    public TextField idField;
    public TextField projField;
    public TextField nomeField;
    public TextField precoField;
    public DatePicker dateField;
    public TextField idField1;
    public TextField projField1;
    public TextField nomeField1;
    public TextField precoField1;
    public DatePicker dateField1;
    public TextField idField2;
    public TextField projField2;
    public TextField nomeField2;
    public TextField precoField2;
    public TextField dateField2;
    @FXML
    public TableView<TabelaProjetos>tabela_projetos;
    public TableColumn<TabelaProjetos,Integer>colId;
    public TableColumn<TabelaProjetos,String>colProj;
    public TableColumn<TabelaProjetos,String>colNome;
    Conecta conex = new Conecta();
    Projeto projeto = new Projeto();
    ControllerProjeto control = new ControllerProjeto();
    java.time.LocalDate setDate;
    java.sql.Date date;
    public void initialize(){
        atuTabela();
    }

    public void atuTabela(){
        colId.setCellValueFactory(new PropertyValueFactory<TabelaProjetos,Integer>("Id"));
        colProj.setCellValueFactory(new PropertyValueFactory<TabelaProjetos,String>("Proj"));
        colNome.setCellValueFactory(new PropertyValueFactory<TabelaProjetos,String>("NomeC"));
        tabela_projetos.getItems().setAll(listaproj());
    }

    private List<TabelaProjetos> listaproj(){
        conex.conexao();
        List projetos = new LinkedList();
        try{
            conex.executa("select * from projeto");
            while(conex.rs.next()){
                Integer id = conex.rs.getInt(1);
                String proj = conex.rs.getString(2);
                String nome = conex.rs.getString(3);
                TabelaProjetos tabp = new TabelaProjetos();
                tabp.setId(id);
                tabp.setProj(proj);
                tabp.setNomeC(nome);
                projetos.add(tabp);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro na coisinha de adicionar a tabela\nerro:"+ex);
        }
        return projetos;
    }
    //add projetos
    public void OpenAdd_proj(){
        view_projetos.setVisible(false);
        delete_projetos.setVisible(false);
        change_projetos.setVisible(false);
        add_projetos.setVisible(true);
    }
    public void save() {
        projeto.setDatai(dateField.getValue());
        projeto.setProjeto(projField.getText());
        projeto.setNomeC(nomeField.getText());
        projeto.setValor(Double.parseDouble(precoField.getText()));
        control.InserirProjeto(projeto);
        projField.setText(null);
        nomeField.setText(null);
        precoField.setText(null);
        dateField.setValue(null);
        //
        atuTabela();
    }
    //change projetos
    public void OpenChange_proj(){
        add_projetos.setVisible(false);
        view_projetos.setVisible(false);
        delete_projetos.setVisible(false);
        change_projetos.setVisible(true);
    }
    public void search(){
        conex.conexao();
        projField1.setDisable(false);
        nomeField1.setDisable(false);
        precoField1.setDisable(false);
        dateField1.setDisable(false);
        try {
            conex.executa("select * from projeto where id='" + idField1.getText() + "'");
            conex.rs.first();
            nomeField1.setText(conex.rs.getString("nomcliente"));
            projField1.setText(conex.rs.getString("nome"));
            precoField1.setText(String.valueOf(conex.rs.getDouble("valor")));
            date = conex.rs.getDate("datainicio");
            setDate = date.toLocalDate();
            dateField1.setValue(setDate);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao buscar os dados\nerro:"+ex);
        }
        conex.desconnect();
    }
    public void alterar(){
        projeto.setNomeC(nomeField1.getText());
        projeto.setProjeto(projField1.getText());
        projeto.setId(Integer.parseInt(idField1.getText()));
        projeto.setValor(Double.parseDouble(precoField1.getText()));
        projeto.setDatai(dateField1.getValue());
        control.AlteraProjeto(projeto);
        nomeField1.setText(null);
        projField1.setText(null);
        idField1.setText(null);
        precoField1.setText(null);
        dateField1.setValue(null);
        nomeField1.setDisable(true);
        projField1.setDisable(true);
        precoField1.setDisable(true);
        dateField1.setDisable(true);
        //
        atuTabela();
    }
    //remove projetos
    public void OpenRemove_proj(){
        change_projetos.setVisible(false);
        add_projetos.setVisible(false);
        view_projetos.setVisible(false);
        delete_projetos.setVisible(true);
    }
    public void delete(){
        projeto.setId(Integer.parseInt(idField.getText()));
        control.ExcluirProjeto(projeto);
        idField.setText(null);
        //
        atuTabela();
    }
    //view projetos
    public void OpenView_proj(){
        delete_projetos.setVisible(false);
        change_projetos.setVisible(false);
        add_projetos.setVisible(false);
        view_projetos.setVisible(true);
    }
    public void searchview(){
        conex.conexao();
        try {
            conex.executa("select * from projeto where id='" + idField2.getText() + "'");
            conex.rs.first();
            nomeField2.setText(conex.rs.getString("nomcliente"));
            projField2.setText(conex.rs.getString("nome"));
            precoField2.setText(String.valueOf(conex.rs.getDouble("valor")));
            date = conex.rs.getDate("datainicio");
            setDate = date.toLocalDate();
            dateField2.setText(setDate.toString());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao buscar os dados\nerro:"+ex);
        }
        conex.desconnect();
    }
}
