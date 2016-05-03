package br.cesjf.lppo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo
 */
@WebServlet(name = "AnuncioController", 
        urlPatterns = {"/listar.html","/novo.html"})
public class AnuncioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().contains("listar.html")) {
            List<Anuncio> lista = new ArrayList<>();
            AnuncioDAO dao = new AnuncioDAO();
            lista = dao.listaTodos();

            request.setAttribute("anuncios", lista);
            request.getRequestDispatcher("/WEB-INF/listar.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("novo.html")) {
            request.getRequestDispatcher("/WEB-INF/novo.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getRequestURI().contains("novo.html")){
            Anuncio novo = new Anuncio();
            novo.setNome(request.getParameter("nome"));
            novo.setDescricao(request.getParameter("descricao"));
            novo.setPreco(Float.parseFloat(request.getParameter("preco")));
            
            AnuncioDAO dao = new AnuncioDAO();
            dao.criar(novo);
            
            response.sendRedirect("listar.html");
        }
    }
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
