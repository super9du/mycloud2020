package liu.wolf.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Demo ConfigCenterMain3355
 *
 * @author Wolf-Liu
 * @date 2020/11/4 22:16
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigCenterMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3355.class, args);
    }
}
