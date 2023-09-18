package kr.co.seeya.jpaexample.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kr.co.seeya.jpaexample.common.EMF;
import kr.co.seeya.jpaexample.reserve.domain.Review;
import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : kr.co.seeya.jpaexample.main
 * fileName       : MainNativie
 * author         : herot
 * date           : 2023-09-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-18        herot       최초 생성
 */
@Slf4j
public class MainNativie {
    public static void main(String[] args){
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            Review review = new Review("H-01", "작성자", "댓글");
            log.info("persis 실행 전");
            em.persist(review);
            log.info("persis 실행 함");
            log.info("생성한 식별자 : {}", review.getId());
            log.info("커밋하기 전");
            tx.commit();
            log.info("커밋함");
        }catch(Exception ex){
            tx.rollback();
        }finally{
            EMF.close();
        }
    }
}
