
package dao;

import java.util.List;
import usuario.Comentario;

public interface IComentarioDAO {

    public void inserir(Comentario comentario);
    public List<Comentario> recuperar(int idTopico);
    public void fechaConexao();
    
}
