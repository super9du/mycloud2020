package liu.wolf.mycloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Demo OrderZkController
 *
 * @author Wolf-Liu
 * @date 2020/10/24 0:26
 */
@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderZkController {
    final String REQUEST_URL = "http://cloud-provider-payment/payment/zk";
    @Resource
    RestTemplate restTemplate;

    @GetMapping("zk")
    public String paymentZk() {
        return restTemplate.getForObject(REQUEST_URL, String.class);
    }
}
