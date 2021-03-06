
package usuario;

public class Comentario {
    
    private int id_comentario;
    private String comentario;
    private String login;
    private int id_topico;

    public Comentario(String comentario, String login, int id_topico) {
        this.comentario = comentario;
        this.login = login;
        this.id_topico = id_topico;
    }

    public Comentario(int id_comentario, String comentario, String login, int id_topico) {
        this.id_comentario = id_comentario;
        this.comentario = comentario;
        this.login = login;
        this.id_topico = id_topico;
    }
    
    
    
    

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId_topico() {
        return id_topico;
    }

    public void setId_topico(int id_topico) {
        this.id_topico = id_topico;
    }
    
    
    
}
