package liu.wolf.mycloud.controller;

import liu.wolf.mycloud.entity.CommonResult;
import liu.wolf.mycloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Demo OrderController
 *
 * @author Wolf-Liu
 * @date 2020/10/16 22:36
 */
@RestController
@RequestMapping("consumer/payment")
public class OrderController {
    //    private final String URL = "http://localhost:8001/payment";
    private final String URL = "http://CLOUD-PAYMENT-SERVICE/payment";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public CommonResult<?> create(Payment payment) {
        return restTemplate.postForObject(URL, payment, CommonResult.class, payment);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return ((CommonResult<Payment>) restTemplate.getForObject(URL + "/" + id, CommonResult.class));
    }
}
