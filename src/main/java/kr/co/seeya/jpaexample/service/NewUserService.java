package kr.co.seeya.jpaexample.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kr.co.seeya.jpaexample.common.EMF;
import kr.co.seeya.jpaexample.reserve.domain.User;

/**
 * packageName    : kr.co.seeya.jpaexample.service
 * fileName       : NewUserService
 * author         : herot
 * date           : 2023-09-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-17        herot       최초 생성
 */
public class NewUserService {
    public void saveNewUser(User user){
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            em.persist(user);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw ex;
        } finally{
            em.close();
        }
    }
}
