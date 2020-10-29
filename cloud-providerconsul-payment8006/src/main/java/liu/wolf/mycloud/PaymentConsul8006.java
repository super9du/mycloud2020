package liu.wolf.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Demo PaymentConsul8006
 *
 * @author Wolf-Liu
 * @date 2020/10/25 14:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsul8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsul8006.class, args);
    }

}
