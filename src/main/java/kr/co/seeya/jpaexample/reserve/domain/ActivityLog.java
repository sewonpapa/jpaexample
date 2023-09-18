package kr.co.seeya.jpaexample.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "activity_log")
public class ActivityLog {
    @Id
    @SequenceGenerator(
            name = "log_seq_gen",                   // @GeneratedValue 에서 사용할 이름
            sequenceName = "activity_seq",
            //schema = "crm",
            allocationSize = 1                      // allocationSize는 반드시 1로 지정 정확한 이유는 모르겠지만 나중에 중복 오류 난다고함...
    )
    @GeneratedValue(generator = "log_seq_gen")
    private Long id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "activity_type")
    private String activityType;
    private LocalDateTime created;

    protected ActivityLog() {
    }

    public ActivityLog(String userId, String activityType) {
        this.userId = userId;
        this.activityType = activityType;
        this.created = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getActivityType() {
        return activityType;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
