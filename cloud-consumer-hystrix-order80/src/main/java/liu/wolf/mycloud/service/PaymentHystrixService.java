package liu.wolf.mycloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Demo PaymentHystrixService
 *
 * @author Wolf-Liu
 * @date 2020/11/1 22:26
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", path = "payment/hystrix/"
        , fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {
    @GetMapping("ok/{id}")
    public String ok(@PathVariable("id") Long id);

    @GetMapping("timeout/{id}")
    public String timeout(@PathVariable("id") Long id);

    @GetMapping("exception/{id}")
    public String exception(@PathVariable("id") Long id);
}
