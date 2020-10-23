package liu.wolf.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 * Demo OrderZkMain
 *
 * @author Wolf-Liu
 * @date 2020/10/24 0:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain.class, args);
    }
}
