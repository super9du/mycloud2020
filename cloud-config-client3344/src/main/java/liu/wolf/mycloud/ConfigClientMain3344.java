package liu.wolf.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Demo ConfigClientMain3344
 *
 * @author Wolf-Liu
 * @date 2020/11/4 23:00
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3344.class, args);
    }
}
