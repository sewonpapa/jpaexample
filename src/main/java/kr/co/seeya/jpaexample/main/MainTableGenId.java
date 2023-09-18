package kr.co.seeya.jpaexample.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kr.co.seeya.jpaexample.common.EMF;
import kr.co.seeya.jpaexample.reserve.domain.AccessLog;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;

@Slf4j
public class MainTableGenId {
    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            AccessLog accessLog = new AccessLog("/path01", LocalDateTime.now());
            log.info("persist 실행 전");
            em.persist(accessLog);
            log.info("persist 실행 함");
            log.info("생성한 식별자: {}", accessLog.getId());
            log.info("커밋하기 전");
            tx.commit();
            log.info("커밋함");
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        EMF.close();
    }
}
