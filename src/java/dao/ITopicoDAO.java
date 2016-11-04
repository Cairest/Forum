package dao;

import java.util.List;
import usuario.Topico;

public interface ITopicoDAO {
    
    public void inserir(Topico topico);
    public Topico recuperar(int idTopico);
    public List<Topico> listaTopicos();
    public void fechaConexao();
    
}
