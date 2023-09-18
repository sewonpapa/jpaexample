package kr.co.seeya.jpaexample.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kr.co.seeya.jpaexample.common.EMF;
import kr.co.seeya.jpaexample.reserve.domain.Review;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainNative {
    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Review review = new Review(5, "H-01", "작성자", "댓글");
            log.info("persist 실행 전");
            em.persist(review);
            log.info("persist 실행 함");
            log.info("생성한 식별자: {}", review.getId());
            log.info("커밋하기 전");
            tx.commit();
            log.info("커밋함");
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
        EMF.close();
    }
}
