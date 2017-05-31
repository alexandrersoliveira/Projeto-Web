package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dominio.Produto;

/**
 * Servlet implementation class ServletAbrirInclusaoProduto
 */
@WebServlet("/abrirInclusaoProduto")
public class ServletAbrirInclusaoProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirInclusaoProduto() {
        super();
    }

	/**
	 * Método que abre o formulário para inclusão de um novo produto.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produto produto = new Produto();
		
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
