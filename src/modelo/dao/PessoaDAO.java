package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Pessoa;

public class PessoaDAO {
	
	private EntityManager manager;

	public PessoaDAO() {
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

	public void incluir(Pessoa obj) {
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

	public void alterar(Pessoa obj) {
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

	public void remover(Pessoa obj) {
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

	public Pessoa buscar(Integer chave) {
		return this.manager.find(Pessoa.class, chave);
	}

	public List<Pessoa> buscarTodos() {
		
		String jpql = "from Pessoa p  order by p.descricao";
		TypedQuery<Pessoa> query = this.manager.createQuery(jpql, Pessoa.class);
		
		return query.getResultList();
	}
}
