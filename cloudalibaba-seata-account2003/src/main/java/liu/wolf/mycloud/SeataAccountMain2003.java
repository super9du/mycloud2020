package liu.wolf.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Demo SeataOrderMain2001
 *
 * @author Wolf-Liu
 * @date 2020/11/28 23:18
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("liu.wolf.mycloud.dao")
@EnableFeignClients
@EnableDiscoveryClient
public class SeataAccountMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain2003.class, args);
    }
}
