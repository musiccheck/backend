package bcy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MusicCheckApplication {

    public static void main(String[] args) {
        // DevTools 자동 재시작 방지
        System.setProperty("spring.devtools.restart.enabled", "false");
        
        try {
            log.info("애플리케이션 시작 중...");
            SpringApplication.run(MusicCheckApplication.class, args);
            log.info("애플리케이션이 성공적으로 시작되었습니다.");
        } catch (Exception e) {
            log.error("애플리케이션 시작 실패: ", e);
            e.printStackTrace();
            System.exit(1);
        }
    }

}