package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//JPA
public class JPAutil {
	
	private static final EntityManagerFactory factory=
			Persistence.createEntityManagerFactory("pb_quiz");
	
	public static  EntityManager getEntityManager() {
		
		return factory.createEntityManager();
		
	}
}

