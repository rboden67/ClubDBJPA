package com.jrb.ClubDBJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ClubJPAConfig.class);
		
		EntityManagerFactory entityManagerFactory = applicationContext.getBean(EntityManagerFactory.class);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select memid from Member");
		List<Member> members = query.getResultList();
		
		for(Member mem : members) {
			System.out.println(mem.toString());
		}
		
		entityManager.close();
	}
}
