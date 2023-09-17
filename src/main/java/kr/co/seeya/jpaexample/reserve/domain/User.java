package kr.co.seeya.jpaexample.reserve.domain;

import jakarta.persistence.*;
import lombok.Data;

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
@Data
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

    public void changeName(String newName){
        this.name = newName;
    }
}
