package br.com.teste.banco.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.teste.banco.model.Time;
import br.com.teste.banco.util.HibernateUtil;

public class TimeDao {

	

	public void save(Time time) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(time);
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
