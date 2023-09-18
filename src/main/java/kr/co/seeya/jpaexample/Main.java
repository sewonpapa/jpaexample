package kr.co.seeya.jpaexample;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import kr.co.seeya.jpaexample.common.EMF;
import kr.co.seeya.jpaexample.reserve.domain.User;
import kr.co.seeya.jpaexample.service.ChangeNameService;
import kr.co.seeya.jpaexample.service.GetUserService;
import kr.co.seeya.jpaexample.service.NewUserService;
import kr.co.seeya.jpaexample.service.RemoveUserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Remove;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

/**
 * packageName    : kr.co.seeya.jpaexample
 * fileName       : Main
 * author         : herot
 * date           : 2023-09-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-18        herot       최초 생성
 */
@Component
@Slf4j
public class Main {
    private static NewUserService newUserService = new NewUserService();
    private static GetUserService getUserService = new GetUserService();
    private static ChangeNameService changeNameService = new ChangeNameService();
    private static RemoveUserService removeUserService = new RemoveUserService();

    @PostConstruct
    public void progRun(){
        System.out.println("11111111111");
        EMF.init();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                System.out.print("명령어를 입력하세요. : ");
                String line = reader.readLine();
                if(line == null) break;

                if(line.startsWith("new ")){
                    handleNew(line);
                }else if(line.startsWith("get ")){
                    handleGet(line);
                }else if(line.startsWith("change name")){
                    handleChangeName(line);
                }else if(line.startsWith("remove ")){
                    handleRemove(line);
                }else if(line.startsWith("exit")){
                    break;
                }else{
                    System.out.println("잘못 입력했습니다. 다시 입력 해 주세요.");
                }
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            EMF.close();
        }
        log.info("이거 잘 타나요 ?????");
    }

    private static void handleNew(String line){
        String[] v = line.substring(4).split(" ");
        User user = null;
        try {
            if (v.length != 2) {
                log.info("파라메터가 정상적으로 전달되지 않았습니다.");
            } else {
                user = new User(v[0], v[1], LocalDateTime.now());
                new NewUserService().saveNewUser(user);
                log.info("새 사용자 등록완료!");
            }
        }catch(EntityExistsException e){
            log.info("사용자가 이미 존재함 : {}", user == null? "null" : user.getEmail());
        }
    }

    private static void handleGet(String line){
        String[] v = line.substring(4).split(" ");
        User user = null;
        try {
            if (v.length != 1) {
                log.info("파라메터가 정상적으로 전달되지 않았습니다.");
            } else {
                user = new GetUserService().getUser(v[0]);
                log.info("사용자 정보 : {}", user);
            }
        }catch(RuntimeException e){
            log.info("사용자가 존재하지 않음 : {}", user == null? "null" : user.getEmail());
        }
    }

    private static void handleChangeName(String line){
        String[] v = line.substring(12).split(" ");
        User user = null;
        try {
            if (v.length != 2) {
                log.info("파라메터가 정상적으로 전달되지 않았습니다.");
            } else {
                new ChangeNameService().changeName(v[0], v[1]);
                log.info("새 사용자 정보 변경! : {}, {}", v[0], v[1]);
            }
        }catch(RuntimeException e){
            log.info("사용자가 존재하지 않음 : {}", user == null? "null" : user.getEmail());
        }
    }

    private static void handleRemove(String line){
        String[] v = line.substring(7).split(" ");
        try {
            if (v.length != 1) {
                log.info("파라메터가 정상적으로 전달되지 않았습니다.");
            } else {
                new RemoveUserService().removeUser(v[0]);
                log.info("사용자 삭제함 : {}", v[0]);
            }
        }catch(RuntimeException e){
            log.info("사용자가 존재하지 않음 : {}", v[0] == null? "null" : v[0]);
        }
    }
}
