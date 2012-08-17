package nl.obs.core.db.manager;

import javax.persistence.EntityManagerFactory;

public class DBUtils {
	public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = javax.persistence.Persistence.createEntityManagerFactory("tibri");
}
