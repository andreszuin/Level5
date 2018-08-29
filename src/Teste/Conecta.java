package Teste;

import javax.swing.*;
import java.sql.*;

public class Conecta {
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.mariadb.jdbc.Driver";
    private String caminho = "jdbc:mariadb://localhost:3306/level5";
    private String usuario = "root";
    private String senha = "1234";
    public Connection conn;

    public void conexao(){
        try {
            System.setProperty("jdbc.Drivers",driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null,"conexão realizada com sucesso");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao conectar");
        }
    }

    public void executa(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro no executa");
        }
    }

    public void desconnect(){
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null,"desconectado com sucesso");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao desconectar");
        }

    }
}
