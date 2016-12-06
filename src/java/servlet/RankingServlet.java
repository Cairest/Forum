
package servlet;

import funcao.Funcao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exibeRanking")
public class RankingServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("rankingUsuarios", new Funcao().listaRanking());
        request.getRequestDispatcher("/ranking.jsp").forward(request, response);
        
    }

}
