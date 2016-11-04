package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import usuario.Topico;
import usuario.Usuario;

public class TopicoDAO implements ITopicoDAO {
    
    private Connection conn;    
    
        public TopicoDAO() {
        try {
            this.conn = ConexaoDB.class.newInstance().getConnection();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
        
    @Override
    public void fechaConexao() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        

    @Override
    public void inserir(Topico topico) {
        try{
            String sql = "INSERT INTO public.topico(id_topico, titulo, conteudo, login) VALUES (?, ?, ?, ?);";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, topico.getId_Topico());
            stm.setString(2, topico.getTitulo());
            stm.setString(3, topico.getConteudo());
            stm.setString(4, topico.getLogin());
            stm.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Não foi possível executar o acesso ao banco de dados", e);
            }
    }
    

    @Override
    public Topico recuperar(int idTopico) {
	Topico t = null;
	try{
            String sql = "SELECT * FROM topico WHERE id_topico = ?;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, idTopico);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                t = new Topico(idTopico, rs.getString("titulo"),
                        rs.getString("conteudo"), rs.getString("login"));
            }
      	} catch (SQLException e) {
            
	}
	return t;
    }

    @Override
    public List<Topico> listaTopicos() {
	List<Topico> lista = new ArrayList<>();
	try{
            String sql = "SELECT * FROM topico ORDER BY id_topico ASC";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
		lista.add(new Topico(rs.getInt("id_topico"), rs.getString("titulo"),
                        rs.getString("conteudo"), rs.getString("login"))); 
            }
	} catch (SQLException e) {
		throw new RuntimeException("Não foi possível escutar o acesso",e);
	}
	return lista;
    }
    
}
