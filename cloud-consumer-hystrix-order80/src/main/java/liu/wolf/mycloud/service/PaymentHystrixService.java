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
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE" // 消费服务名
        , path = "payment/hystrix/" // 消费服务的URL路径
        , fallback = PaymentHystrixServiceImpl.class) // 失败回调
public interface PaymentHystrixService {
    @GetMapping("ok/{id}")
    public String ok(@PathVariable("id") Long id);

    @GetMapping("timeout/{id}")
    public String timeout(@PathVariable("id") Long id);

    @GetMapping("exception/{id}")
    public String exception(@PathVariable("id") Long id);
}
