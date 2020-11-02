package liu.wolf.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Demo HystrixDashbordMain9001
 *
 * @author Wolf-Liu
 * @date 2020/11/2 21:38
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashbordMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashbordMain9001.class, args);
    }
}
