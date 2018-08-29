package Controllers;

import Model.Projeto;
import Teste.Conecta;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerProjeto {
    Conecta conex = new Conecta();
    public void InserirProjeto(Projeto projeto){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("insert into projeto(nome,nomcliente,valor,datainicio)values(?,?,?,?)");
            pst.setString(1,projeto.getProjeto());
            pst.setString(2,projeto.getNomeC());
            pst.setDouble(3,projeto.getValor());
            pst.setDate(4,java.sql.Date.valueOf(projeto.getDatai()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"salvo com sucesso");

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
    public void ExcluirProjeto(Projeto projeto){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from projeto where id=?");
            pst.setInt(1,projeto.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null,"deletado com sucesso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao excluir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
    public void AlteraProjeto(Projeto projeto){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("update projeto set nome = ?, nomcliente = ?, valor = ?, datainicio = ? where id = ?");
            pst.setString(1,projeto.getProjeto());
            pst.setString(2,projeto.getNomeC());
            pst.setDouble(3,projeto.getValor());
            pst.setDate(4,java.sql.Date.valueOf(projeto.getDatai()));
            pst.setInt(5,projeto.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null,"dados alterados com suceso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao alterar os dados\n erro:"+ex);
        }
    }
}
