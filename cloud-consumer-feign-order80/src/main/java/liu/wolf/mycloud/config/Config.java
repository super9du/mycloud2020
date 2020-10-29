package liu.wolf.mycloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Demo Config
 *
 * @author Wolf-Liu
 * @date 2020/10/26 22:37
 */
@Configuration
public class Config {
    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }
}
