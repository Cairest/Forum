package funcao;

import dao.ITopicoDAO;
import dao.IUsuarioDAO;
import dao.TopicoDAO;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import usuario.Topico;
import usuario.Usuario;

public class Funcao {
    
    private IUsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario;
    private ITopicoDAO topicoDAO = new TopicoDAO();
    
    public void cadastrar(String login, String email, String nome, String senha) throws Exception{
        if(usuarioDAO.recuperar(login)== null){
            usuarioDAO.inserir(new Usuario(login, email, nome, senha, 0));
            usuarioDAO.fechaConexao();
        }else{
            throw new NullPointerException();
        }
            
    }
    
    public String logar(String login, String senha) throws Exception{
        usuario = usuarioDAO.recuperar(login);
        usuarioDAO.fechaConexao();
        if(usuario.getSenha().equals(senha)){
            return usuario.getLogin();
        }else{
            throw new Exception();
        }
    }
    
    public List<Topico> listaTopicos(){
        
        return topicoDAO.listaTopicos();
    }
     
    public List<Usuario> listaRanking(){
        return usuarioDAO.ranking();
    }
    
    public void inserirNovoTopico(String titulo, String conteudo, String login){
        topicoDAO.inserir(new Topico(titulo, conteudo, login));
    }
    
    public Topico recuperaTopico(int id_Topico){
        return topicoDAO.recuperar(id_Topico);
    }
}
