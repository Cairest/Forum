/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

public class Topico {
    
    private int id_Topico;
    private String titulo;
    private String conteudo;
    private String login;

    public int getId_Topico() {
        return id_Topico;
    }

    public void setId_Topico(int id_Topico) {
        this.id_Topico = id_Topico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Topico(int id_Topico, String titulo, String conteudo, String login) {
        this.id_Topico = id_Topico;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.login = login;
    }
    
    public Topico(String titulo, String conteudo, String login) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.login = login;
    }    
    
}
