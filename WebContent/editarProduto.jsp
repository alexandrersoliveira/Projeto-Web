<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produtos</title>
</head>

<jsp:useBean id="produto" class="modelo.dominio.Produto" 
		scope="request"></jsp:useBean>

<body>
	<form action="salvarProduto" method="post">
		<input type="hidden" name="codigo" value="<%=produto.getCodigoStr() %>">
		<table border="0" cellpadding="5" cellspacing="0">
			<tr>
				<td>Código:</td>
				<td><%=produto.getCodigoStr() %></td>
			</tr>
			<tr>
				<td>Descrição:</td>
				<td><input type="text" name="descricao" value="<%=produto.getDescricao() %>" size="40" maxlength="100"></td>
			</tr>
			<tr>
				<td>Preço de Custo:</td>
				<td><input type="text" name="custo" value="<%=produto.getPrecoCustoStr() %>" size="10" maxlength="10"></td>
			</tr>
			<tr>
				<td>Preço de Venda:</td>
				<td><input type="text" name="venda" value="<%=produto.getPrecoVendaStr() %>" size="10" maxlength="10"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Salvar Produto">
					<input type="button" value="Cancelar" onclick="location='listarProdutos'"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>