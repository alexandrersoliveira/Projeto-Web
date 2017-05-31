package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tab_clientes")
public class Cliente extends Pessoa {

	@Column(name="limite_credito", columnDefinition="NUMERIC(15,2)")
	private Float limiteDeCredito;

	public Float getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(Float limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}
	
	
	
}
