package liu.wolf.mycloud.service;

import liu.wolf.mycloud.entity.CommonResult;
import liu.wolf.mycloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Demo PaymentFeignService
 *
 * @author Wolf-Liu
 * @date 2020/10/26 22:11
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
