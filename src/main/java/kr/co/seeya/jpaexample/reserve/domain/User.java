package kr.co.seeya.jpaexample.reserve.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

/**
 * packageName    : kr.co.seeya.jpaexample.reserve.domain
 * fileName       : User
 * author         : herot
 * date           : 2023-09-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-06        herot       최초 생성
 */
@Entity
@Table(name="user")
public class User {
    @Id
    private String email;
    private String name;
    @Column(name="create_date")
    private LocalDateTime createDate;

    protected User(){

    }

    public User(String email, String name, LocalDateTime createDate){
        this.email = email;
        this.name = name;
        this.createDate = createDate;
    }
}
