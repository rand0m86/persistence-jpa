package com.magas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-app-persistence-unit");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Message message = new Message();
		message.setText("Hello world!");
		
		em.persist(message);
		tx.commit();
		em.close();

		EntityManager em2 = emf.createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();
		tx2.begin();

		@SuppressWarnings("unchecked")
		List<Message> messages = em2.createQuery("select m from Message m order by m.text asc")
				.getResultList();

		System.out.println(String.format("Found %d message(s)", messages.size()));
		for (Message msg : messages) {
			System.out.println(msg.getText());
		}
		tx2.commit();
		em2.close();
		emf.close();
	}
}
