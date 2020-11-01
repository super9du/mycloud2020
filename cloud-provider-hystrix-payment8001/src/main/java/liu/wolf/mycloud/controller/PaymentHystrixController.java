package liu.wolf.mycloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Demo PaymentController
 *
 * @author Wolf-Liu
 * @date 2020/11/1 18:31
 */
@RestController
@RequestMapping("payment/hystrix")
public class PaymentHystrixController {

    @GetMapping("ok/{id}")
    public String ok(@PathVariable("id") Long id) {
        return "hystrix/payment/ok: " + id;
    }

    @GetMapping("timeout/{id}")
    public String timeout(@PathVariable("id") Long id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hystrix/payment/timeout: " + id;
    }

    @GetMapping("exception/{id}")
    public String exception(@PathVariable("id") Long id) {
        int x = 10 / 0;
        return "hystrix/payment/exception: " + id;
    }
}
