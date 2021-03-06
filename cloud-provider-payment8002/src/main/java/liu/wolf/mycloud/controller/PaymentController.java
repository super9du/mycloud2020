package liu.wolf.mycloud.controller;

import liu.wolf.mycloud.entity.CommonResult;
import liu.wolf.mycloud.entity.Payment;
import liu.wolf.mycloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Demo PaymentController
 *
 * @author Wolf-Liu
 * @date 2020/10/16 21:37
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        if (i > 0)
            return new CommonResult<>(200, "创建成功 (8002)");
        else
            return new CommonResult<>(500, "插入数据失败 (8002)");
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment)
            return new CommonResult<>(200, "成功 (8002)", payment);
        else
            return new CommonResult<>(404, "没有找到订单 (8002)");
    }
}
