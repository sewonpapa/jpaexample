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

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
//		EntityManager entityManager = emf.createEntityManager();
//		EntityTransaction transaction = entityManager.getTransaction();
//
//		try{
//			// 사용자 저장
////			transaction.begin();
////			User user = new User("user@user.com", "user", LocalDateTime.now());
////			entityManager.persist(user);
////			transaction.commit();
//
//			// 사용자 정보 조회
//			transaction.begin();
//			User user = entityManager.find(User.class, "user@user.com");
//
//			if(user == null){
//				System.out.println("User 없음");
//			}else{
//				System.out.printf("User 있음 : email=%s, name=%s, createDate=%s\n", user.getEmail(), user.getName(), user.getCreateDate());
//
//				// 사용자 정보 update
//				user.setName("임환기222");
//			}
//			transaction.commit();
//
//			// 사용자 정보 update
//			transaction.begin();
//
//
//
//			transaction.commit();
//		}catch(Exception ex){
//			ex.printStackTrace();
//			transaction.rollback();
//		}finally {
//			entityManager.close();
//		}
//
//		emf.close();

		SpringApplication.run(JpaexampleApplication.class, args);
	}
}
