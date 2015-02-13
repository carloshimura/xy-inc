package org.xy_poi.data.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.xy_poi.data.POI;


/**
 * Classe que gerencia os acessos ao banco de dados
 * @author carlos
 *
 */
public class POIDatabaseAcess {
	
	private SessionFactory m_sessionFactory;
	
	/**
	 * Construtor, inicia as variáveis para gerencialmento de sessões com o banco de dados
	 */
	public POIDatabaseAcess()
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		configuration.getProperties()).build();

		m_sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
	}
	
	/**
	 * insere um POI
	 * @param poi poi a ser inserido
	 */
	public void insertPoi(POI poi)
	{
		Session session = m_sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(poi);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {	
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	/**
	 * retorna todos os POIs do banco de dados
	 * @return POIs do banco de dados
	 */
	@SuppressWarnings("unchecked")
	public List<POI> getAllPOIs() {
		Session session = m_sessionFactory.openSession();
		List<POI> list = null;
		try {
			Criteria criteria = session.createCriteria(POI.class);
	        list = criteria.list();
			
		} catch (HibernateException e) {	
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return list;
	}
}
