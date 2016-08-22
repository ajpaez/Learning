package apr.jpa.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum EntityManagerFactorySingleton {
	INSTANCE;

	private static final String PERSISTENCE_UNIT_MI_PELU = "PersistenceUnit";
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;

	private EntityManagerFactorySingleton() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_MI_PELU);
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void cerrar() {
		if (entityManager != null)
			entityManager.close();
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}

	public EntityManager getEntityManager() {

		return entityManager;
	}
}
