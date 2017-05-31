package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ProdutoDAO;
import modelo.dominio.Produto;

/**
 * Servlet implementation class ServletEditarProduto
 */
@WebServlet("/editarProduto")
public class ServletEditarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarProduto() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigo = request.getParameter("codigo");
		Integer chave = Integer.parseInt(codigo);
		
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscar(chave);
		
		request.setAttribute("produto", produto);
		
		RequestDispatcher desp = request.getRequestDispatcher("editarProduto.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
