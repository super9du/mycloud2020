package liu.wolf.mycloud.controller;

import liu.wolf.mycloud.entity.CommonResult;
import liu.wolf.mycloud.entity.Payment;
import liu.wolf.mycloud.service.FeignPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Demo FeignOrderController
 *
 * @author Wolf-Liu
 * @date 2020/11/26 23:51
 */
@RestController
public class FeignOrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignPaymentService feignPaymentService;

    @Value("${provider.server-name}")
    private String serverName;

    @SuppressWarnings("unchecked")
    @GetMapping("rest/{id}")
    public CommonResult<Payment> getByRestTemplate(@PathVariable("id") Long id) {
        return (CommonResult<Payment>) restTemplate.getForObject(
                "http://" + serverName + "/payment-sql/" + id, CommonResult.class);
    }

    @GetMapping("feign/{id}")
    public CommonResult<Payment> getByFeign(@PathVariable("id") Long id) {
        return feignPaymentService.getPaymentById(id);
    }
}
