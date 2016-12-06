
package servlet;

import funcao.Funcao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insereTopico")
public class InsereTopicoServlet extends HttpServlet {

       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = (String) request.getSession().getAttribute("nome");
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        
        Funcao fl = new Funcao();
        fl.inserirNovoTopico(titulo, conteudo, nome);
        
        request.setAttribute("listaTopicos", fl.listaTopicos());
        request.getRequestDispatcher("inicioForum.jsp").forward(request, response);
        
        
        
    }


}
