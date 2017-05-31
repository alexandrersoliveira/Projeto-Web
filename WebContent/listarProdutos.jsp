<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produtos</title>
</head>
<body>
<%
	List<Produto> lista = (List<Produto>)request.getAttribute("lista");
	if (lista == null)
		lista = new ArrayList<Produto>();
%>

<h1>Cadastro de Produtos</h1>

<a href="abrirInclusaoProduto">Novo Produto</a>

<table border="1" cellpadding="5" cellspacing="0"> 
	<tr>
		<td>Opções</td>
		<td>Código</td>
		<td>Descrição</td>
		<td>Preço de Custo</td>
		<td>Preço de Venda</td>
	</tr>
<%
for (Produto produto : lista) {
%>
	<tr>
		<td><a href="editarProduto?codigo=<%=produto.getCodigo()%>">Alterar</a></td>
		<td><%=produto.getCodigo()%></td>
		<td><%=produto.getDescricao()%></td>
		<td><%=produto.getPrecoCustoStr()%></td>
		<td><%=produto.getPrecoVendaStr()%></td>
	</tr>
<%	}
%>
</table>

</body>
</html>