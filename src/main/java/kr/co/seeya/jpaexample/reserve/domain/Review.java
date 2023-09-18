package kr.co.seeya.jpaexample.reserve.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * packageName    : kr.co.seeya.jpaexample.reserve.domain
 * fileName       : Review
 * author         : herot
 * date           : 2023-09-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-18        herot       최초 생성
 */
@Data
@Entity
public class Review {
    @Id
    @Column(name="review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="hotel_id")
    private String hotelId;
    private int mark;
    @Column
    private String writerName;
    private String comment;
    private LocalDateTime created;

    protected Review(){

    }

    protected Reiview(String hotelId, String writerName, String comment){
        this.hotelId = hotelId;
        this.writerName = writerName;
        this.comment = comment;
    }



}
