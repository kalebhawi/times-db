package br.com.teste.banco.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.teste.banco.model.Jogador;
import br.com.teste.banco.util.HibernateUtil;



public class JogadorDao {
	
	public List<Jogador> listar() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Jogador> cq = cb.createQuery(Jogador.class);
			Root<Jogador> rootEntry = cq.from(Jogador.class);
			CriteriaQuery<Jogador> all = cq.select(rootEntry);

			TypedQuery<Jogador> allQuery = session.createQuery(all);
			return allQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	
	//metodo para puxar todas info do objeto jogador
	public Jogador porId(Long idJogador) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.find(Jogador.class, idJogador);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	//metodo para dar update em informações dos jogadores
	public void persistir(Jogador jogador) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(jogador);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
}
