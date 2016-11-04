package dao;

import java.sql.SQLException;
import java.util.List;
import usuario.Usuario;

public interface IUsuarioDAO {
    
    public void inserir(Usuario u);
    public Usuario recuperar(String login) throws Exception;
    public void adicionarPontos(String login, int pontos);
    public List<Usuario> ranking();
    public void fechaConexao();
 //   public String autenticar(String login, String senha) throws Exception;
    
}
