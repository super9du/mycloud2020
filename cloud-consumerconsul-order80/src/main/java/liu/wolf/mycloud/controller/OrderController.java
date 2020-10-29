package liu.wolf.mycloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Demo OrderController
 *
 * @author Wolf-Liu
 * @date 2020/10/25 14:51
 */
@RestController
@RequestMapping("consumer/payment")
@Slf4j
public class OrderController {
    final String REQUEST_URL = "http://cloud-provider-payment/payment/consul";
    @Resource
    RestTemplate restTemplate;

    @GetMapping("consul")
    public String payment() {
        return restTemplate.getForObject(REQUEST_URL, String.class);
    }
}
