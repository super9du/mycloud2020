package liu.wolf.mycloud.service;

import liu.wolf.mycloud.entity.CommonResult;
import liu.wolf.mycloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Demo FeiginPaymentService
 *
 * @author Wolf-Liu
 * @date 2020/11/27 0:00
 */
@FeignClient(value = "nacos-payment-provider", fallback = FeignPaymentServiceFallback.class)
public interface FeignPaymentService {
    @GetMapping(value = "/payment-sql/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
