package Controllers;
import Model.*;
import Teste.Conecta;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerMembro {
    Conecta conex = new Conecta();
    public void InserirMembro(Membro membro){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("insert into membro(nome,cpf,rg,oexpeditor,dataentrada,nacionalidade,ecivil,profissao,endereco,cep)values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,membro.getNome());
            pst.setString(2, membro.getCpf());
            pst.setString(3,membro.getRg());
            pst.setString(4,membro.getOe());
            pst.setDate(5,java.sql.Date.valueOf(membro.getDatae()));
            pst.setString(6,membro.getNac());
            pst.setString(7,membro.getEcivil());
            pst.setString(8,membro.getProf());
            pst.setString(9,membro.getEnd());
            pst.setString(10,membro.getCep());
                pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"salvo com sucesso");


        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }

    public void ExcluirMembro(Membro membro){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from membro where cpf=?");
            pst.setString(1,membro.getCpf());
            pst.execute();
            JOptionPane.showMessageDialog(null,"deletado com sucesso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao excluir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }

    public void AlteraMembro(Membro membro){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("update membro set nome = ?, rg = ?, oexpeditor = ?, dataentrada = ?, nacionalidade = ?, ecivil = ?, profissao = ?, endereco = ?, cep = ? where cpf = ?");
            pst.setString(1,membro.getNome());
            pst.setString(2,membro.getRg());
            pst.setString(3,membro.getOe());
            pst.setDate(4,java.sql.Date.valueOf(membro.getDatae()));
            pst.setString(5,membro.getNac());
            pst.setString(6,membro.getEcivil());
            pst.setString(7,membro.getProf());
            pst.setString(8,membro.getEnd());
            pst.setString(9,membro.getCep());
            pst.setString(10,membro.getCpf());
            pst.execute();
            JOptionPane.showMessageDialog(null,"dados alterados com suceso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao alterar os dados\n erro:"+ex);
        }
    }
}
