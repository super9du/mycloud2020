package liu.wolf.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Demo MyRule
 *
 * @author Wolf-Liu
 * @date 2020/10/26 20:35
 */
@Configuration
public class MyRule {
    @Bean
    IRule iRule(){
        return new RandomRule();
    }
}
