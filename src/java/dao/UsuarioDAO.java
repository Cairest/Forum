/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import usuario.Usuario;

public class UsuarioDAO implements IUsuarioDAO{
    
    private Connection conn;

    public UsuarioDAO() {
        try {
            this.conn = ConexaoDB.class.newInstance().getConnection();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void fechaConexao() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Usuario u) {
        try{
            String sql = "INSERT INTO public.usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, u.getLogin());
            stm.setString(2, u.getEmail());
            stm.setString(3, u.getNome());
            stm.setString(4, u.getSenha());
            stm.setInt(5, u.getPontos());
            stm.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Não foi possível executar o acesso ao banco de dados", e);
            }
    }

    @Override
    public Usuario recuperar(String login) throws Exception{
	Usuario u = null;
	try{
            String sql = "SELECT * FROM usuario WHERE login = ?;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                u = new Usuario(login, rs.getString("email"), rs.getString("nome"), 
                        rs.getString("senha"), rs.getInt("pontos"));
            }
      	} catch (SQLException e) {
            
	}
	return u;
    }

    @Override
    public void adicionarPontos(String login, int pontos) {
	try{
	String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?;";
	PreparedStatement stm = conn.prepareStatement(sql);
	stm.setInt(1, pontos);
	stm.setString(2, login);
	stm.executeUpdate();
	conn.close();
	} catch (SQLException e) {
            e.printStackTrace();
	}
    }

    @Override
    public List<Usuario> ranking() {
	List<Usuario> ranking = new ArrayList<>();
	try{
            String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
		ranking.add(new Usuario(rs.getString("login"), rs.getString("email"), rs.getString("nome"), 
				rs.getString("senha"), rs.getInt("pontos"))); 
            }
	} catch (SQLException e) {
		throw new RuntimeException("Não foi possível escutar o acesso",e);
	}
	return ranking;
    }
    
 
}
