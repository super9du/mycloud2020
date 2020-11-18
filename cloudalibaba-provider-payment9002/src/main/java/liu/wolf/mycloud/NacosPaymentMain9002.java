package liu.wolf.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Demo NacosPaymentMain9002
 *
 * @author Wolf-Liu
 * @date 2020/11/15 19:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9002.class, args);
    }
}
