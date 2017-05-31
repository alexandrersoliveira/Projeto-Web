package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Produto;

public class ProdutoDAO {
	
	private EntityManager manager;

	public ProdutoDAO() {
		super();
		
		this.manager = JPAUtil.getEntityManager();
	}

	public void fecharConexao() {
		this.manager.close();
	}

	@Override
	protected void finalize() throws Throwable {
		this.fecharConexao();
	}

	public void incluir(Produto obj) {
		// abrir a transação
		this.manager.getTransaction().begin();
		try {
			// atualizar o objeto
			this.manager.persist(obj);
			// confirmar a transação
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			// desfazer a transação
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
	}

	public void alterar(Produto obj) {
		// abrir a transação
		this.manager.getTransaction().begin();
		try {
			// atualizar o objeto
			this.manager.merge(obj);
			// confirmar a transação
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			// desfazer a transação
			this.manager.getTransaction().rollback();
		}
	}

	public void remover(Produto obj) {
		// abrir a transação
		this.manager.getTransaction().begin();
		try {
			// atualizar o objeto
			this.manager.remove(obj);
			// confirmar a transação
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			// desfazer a transação
			this.manager.getTransaction().rollback();
		}
	}

	public Produto buscar(Integer chave) {
		return this.manager.find(Produto.class, chave);
	}

	public List<Produto> buscarTodos() {
		
		String jpql = "from Produto p  order by p.descricao";
		TypedQuery<Produto> query = this.manager.createQuery(jpql, Produto.class);
		
		return query.getResultList();
	}
}
