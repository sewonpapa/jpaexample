package kr.co.seeya.jpaexample.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kr.co.seeya.jpaexample.common.EMF;
import kr.co.seeya.jpaexample.reserve.domain.User;

/**
 * packageName    : kr.co.seeya.jpaexample.service
 * fileName       : GetUserService
 * author         : herot
 * date           : 2023-09-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-17        herot       최초 생성
 */
public class GetUserService {
    public User getUser(String email){
        EntityManager em = EMF.createEntityManager();

        try {
            User user = em.find(User.class, email);
            if (user == null) {
                throw new RuntimeException();
            }

            return user;
        }finally{
            em.close();
        }
    }
}
