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
 * @date 2020/10/25 14:30
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    @GetMapping("consul")
    public String payment() {
        return "consul " + 8006 + " " + UUID.randomUUID();
    }
}
