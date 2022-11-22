package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Aluno;

public class Programa {

	public static void main(String[] args) {

		Aluno p1 = new Aluno(null, "Juan Figueiredo", "juanf@gmail.com");
		Aluno p2 = new Aluno(null, "Henry Freitas", "henryf@gmail.com");
		Aluno p3 = new Aluno(null, "Luana Brito", "luanab@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("transacao");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Atualização realizada!");
	}

}
