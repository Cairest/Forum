    
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import funcao.Funcao;
import java.util.List;
import usuario.Topico;

@WebServlet("/listaTopicosInicio")
public class ListaTopicosInicioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Topico> listaTopicos = new Funcao().listaTopicos();
        request.setAttribute("listaTopicos", listaTopicos);
        request.getRequestDispatcher("/inicioForum.jsp").forward(request, response);
     
        
    }

   

}
