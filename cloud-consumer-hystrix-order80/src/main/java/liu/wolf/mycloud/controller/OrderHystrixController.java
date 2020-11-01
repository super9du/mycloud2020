package liu.wolf.mycloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import liu.wolf.mycloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Demo OrderHystrixController
 *
 * @author Wolf-Liu
 * @date 2020/11/1 22:29
 */
@RestController
@RequestMapping("consumer")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Long id) {
        return paymentHystrixService.ok(id);
    }

    @GetMapping("payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "timeoutFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String timeout(@PathVariable("id") Long id) {
        return paymentHystrixService.timeout(id);
    }

    @GetMapping("payment/hystrix/exception/{id}")
    public String exception(@PathVariable("id") Long id) {
        return paymentHystrixService.exception(id);
    }

    public String timeoutFallback(Long id) {
        return "请求超时，请稍后重试！ID：" + id;
    }
}
