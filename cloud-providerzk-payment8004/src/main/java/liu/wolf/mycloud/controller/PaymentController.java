package liu.wolf.mycloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Demo PaymentController
 *
 * @author Wolf-Liu
 * @date 2020/10/23 23:55
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @GetMapping("zk")
    public String paymentZk() {
        return "zk " + 8004 + " " + UUID.randomUUID();
    }
}
