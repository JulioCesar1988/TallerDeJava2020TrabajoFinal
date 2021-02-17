package ttps.spring.clasesDAOimp;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import ttps.spring.interfacesDAO.GenericDAO;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	protected Class<T> PersistentClass;

	public GenericDAOHibernateJPA(Class<T> persistentClass) {
		this.setPersistentClass(persistentClass);
	}

	public Class<T> getPersistentClass() {
		return PersistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		PersistentClass = persistentClass;
	}

	@Override
	public T actualizar(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}

	@Override
	public void borrar(T entity) {
		this.getEntityManager().remove(entity);
	}

	@Override
	public T borrar(Serializable id) {
		T entity = this.recuperar(id);
		if (entity != null) {
			this.borrar(entity);
		}
		return entity;
	}

	@Override
	public boolean existe(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T persistir(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public T recuperar(Serializable id) {
		return this.getEntityManager().find(this.getPersistentClass(), id);
	}

	@Override
	public List<T> recuperarTodos() {
		Query q = this.getEntityManager()
				.createQuery("select e from " + this.getPersistentClass().getSimpleName() + " e");
		@SuppressWarnings("unchecked")
		List<T> result = (List<T>) q.getResultList();
		return result;

	}

}