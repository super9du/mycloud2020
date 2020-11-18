package liu.wolf.mycloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Demo NacosOrderController
 *
 * @author Wolf-Liu
 * @date 2020/11/15 19:12
 */
@RestController
@RequestMapping("consumer/payment")
public class NacosOrderController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${provider.server-name}")
    String providerServerName;

    @GetMapping("{id}")
    public String get(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://" + providerServerName + "/payment/" + id, String.class);
    }

}
