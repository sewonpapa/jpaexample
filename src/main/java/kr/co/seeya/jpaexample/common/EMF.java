package kr.co.seeya.jpaexample.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * packageName    : kr.co.seeya.jpaexample.common
 * fileName       : EMF
 * author         : herot
 * date           : 2023-09-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-17        herot       최초 생성
 */
public class EMF {
    private static EntityManagerFactory emf;

    public static void init(){
        emf = Persistence.createEntityManagerFactory("jpabegin");
    }

    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }

    public static void close(){
        emf.close();
    }
}
