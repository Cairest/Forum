package servlet;

import funcao.Funcao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Funcao fl = new Funcao();
        try {
            String nomeUsuario = fl.logar(login, senha);
            request.setAttribute("nome", nomeUsuario);
            request.getRequestDispatcher("inicioForum.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("mensagem", "Login e/ou senha inválido(s)/a");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}
