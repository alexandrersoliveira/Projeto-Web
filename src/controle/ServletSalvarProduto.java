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
 * Servlet implementation class ServletSalvarProduto
 */
@WebServlet("/salvarProduto")
public class ServletSalvarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarProduto() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendError(403, "Não é permitido enviar requisição via GET.");
		
		// doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String descricao = request.getParameter("descricao");
		String custo = request.getParameter("custo");
		String venda = request.getParameter("venda");
		
		Integer codigoInt = null;
		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (NumberFormatException e) {
			codigoInt = null;
		}
		
		Float precoCusto = Float.parseFloat(custo);
		Float precoVenda = Float.parseFloat(venda);
		
		Produto produto = new Produto(codigoInt, descricao, precoCusto, precoVenda);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.alterar(produto);
		
		// RequestDispatcher desp = request.getRequestDispatcher("index.jsp");
		// desp.forward(request, response);
		
		response.sendRedirect("listarProdutos");
	}

}
