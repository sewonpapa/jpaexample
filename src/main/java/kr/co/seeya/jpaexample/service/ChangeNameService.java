package kr.co.seeya.jpaexample.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kr.co.seeya.jpaexample.common.EMF;
import kr.co.seeya.jpaexample.reserve.domain.User;

/**
 * packageName    : kr.co.seeya.jpaexample.service
 * fileName       : ChangeNameService
 * author         : herot
 * date           : 2023-09-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-17        herot       최초 생성
 */
public class ChangeNameService {
    public void changeName(String email, String newName) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            User user = em.find(User.class, email);

            if (user == null)
                throw new RuntimeException();

            user.setName(newName);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }
}
