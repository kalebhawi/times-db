package br.com.teste.banco.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.teste.banco.model.Time;
import br.com.teste.banco.util.HibernateUtil;

public class TimeDao {

	public Time porId(Long idTime) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.find(Time.class, idTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Time> listar() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// builder de consultas
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// objeto que constrói as consultas
			CriteriaQuery<Time> cq = cb.createQuery(Time.class);
			// parametros das consultas
			Root<Time> rootEntry = cq.from(Time.class);
			CriteriaQuery<Time> all = cq.select(rootEntry);

			TypedQuery<Time> allQuery = session.createQuery(all);
			return allQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public void persistir(Time time) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(time);
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
