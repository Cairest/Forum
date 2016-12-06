package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import usuario.Comentario;
import usuario.Topico;

public class ComentarioDAO implements IComentarioDAO{
    
    private Connection conn;    
    
        public ComentarioDAO() {
        try {
            this.conn = ConexaoDB.class.newInstance().getConnection();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
        
    @Override
    public void fechaConexao() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    

    @Override
    public void inserir(Comentario comentario) {
        try {
            String sql = "INSERT INTO public.comentario(comentario, login, id_topico) VALUES (?, ?, ?);";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, comentario.getComentario());
            stm.setString(2, comentario.getLogin());
            stm.setInt(3, comentario.getId_topico());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível escutar o acesso",e);
        }
    }

    @Override
    public List<Comentario> recuperar(int idTopico) {
        List<Comentario> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM topico WHERE id_topico = ?;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, idTopico);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                lista.add(new Comentario(rs.getInt("id_comentario"), rs.getString("comentario")
                        , rs.getString("login"), rs.getInt("id_topico")));
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível escutar o acesso",e);
        }
        return lista;
    }
    
    
}
