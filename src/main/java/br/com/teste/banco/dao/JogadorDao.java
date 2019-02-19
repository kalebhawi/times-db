package br.com.teste.banco.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.teste.banco.model.Jogador;
import br.com.teste.banco.util.HibernateUtil;

public class JogadorDao {

	public void save(Jogador jogador) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(jogador);
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
