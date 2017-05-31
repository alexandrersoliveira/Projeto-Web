package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUTO")
	@SequenceGenerator(name="PRODUTO", allocationSize=1,
						sequenceName="SEQ_PRODUTO")
	private Integer codigo;

	@Column(length = 100, nullable = false)
	private String descricao = "";

	@Column(name = "preco_custo", columnDefinition="NUMERIC(15,2)")
	private Float precoCusto;

	@Column(name = "preco_venda", columnDefinition="NUMERIC(15,2)")
	private Float precoVenda;
	
	@ManyToOne
	@JoinColumn(name="fornecedor_fk", nullable=true)
	private Fornecedor fornecedor;

	public Produto() {
		super();
	}

	public Produto(Integer codigo, String descricao, Float precoCusto, Float precoVenda) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getCodigoStr() {
		if (this.codigo == null)
			return "";
		
		return this.codigo.toString();
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getPrecoCusto() {
		return precoCusto;
	}

	public String getPrecoCustoStr() {
		if (this.precoCusto == null)
			return "";
		
		return this.precoCusto.toString();
	}

	public void setPrecoCusto(Float precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Float getPrecoVenda() {
		return precoVenda;
	}

	public String getPrecoVendaStr() {
		if (this.precoVenda == null)
			return "";
		
		return this.precoVenda.toString();
	}

	public void setPrecoVenda(Float precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", precoCusto=" + precoCusto + ", precoVenda="
				+ precoVenda + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}