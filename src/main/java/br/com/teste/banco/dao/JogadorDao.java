package br.com.teste.banco.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.teste.banco.model.Jogador;
import br.com.teste.banco.util.HibernateUtil;

public class JogadorDao {
	
	public Jogador porId(Long idJogador) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.find(Jogador.class, idJogador);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void save(Jogador jogador) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(jogador);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
}
