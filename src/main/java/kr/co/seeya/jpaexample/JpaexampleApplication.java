package kr.co.seeya.jpaexample;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import kr.co.seeya.jpaexample.reserve.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaexampleApplication {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try{
			transaction.begin();
			User user = new User("user@user.com", "user", LocalDateTime.now());
			entityManager.persist(user);
			transaction.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			transaction.rollback();
		}finally {
			entityManager.close();
		}

		emf.close();

		SpringApplication.run(JpaexampleApplication.class, args);
	}
}
