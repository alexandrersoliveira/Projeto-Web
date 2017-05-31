package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tab_fornecedores")
public class Fornecedor extends Pessoa {

	@Column(name = "limite_compra", columnDefinition = "NUMERIC(15,2)")
	private Float limiteDeCompra;

	@OneToMany(mappedBy = "fornecedor")
	private List<Produto> produtos;

	public Float getLimiteDeCompra() {
		return limiteDeCompra;
	}

	public void setLimiteDeCompra(Float limiteDeCompra) {
		this.limiteDeCompra = limiteDeCompra;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
