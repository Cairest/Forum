/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import funcao.Funcao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1539917
 */
@WebServlet(urlPatterns = {"/cadastro"})
public class CadastroServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        
        Funcao fc = new Funcao();
        try {
            fc.cadastrar(login, email, nome, senha);
            request.setAttribute("mensagem","Cadastro realizado com sucesso!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("mensagem", "Nome de usuário já existente! Comece novamente!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
