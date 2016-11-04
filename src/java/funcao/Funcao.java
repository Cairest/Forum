package funcao;

import dao.IUsuarioDAO;
import dao.UsuarioDAO;
import usuario.Usuario;

public class Funcao {
    
    private IUsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario;
    
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
}
