package liu.wolf.mycloud.service;

import liu.wolf.mycloud.entity.CommonResult;
import liu.wolf.mycloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * Demo FeiginPaymentServiceFallback
 *
 * @author Wolf-Liu
 * @date 2020/11/27 0:06
 */
@Component
public class FeignPaymentServiceFallback implements FeignPaymentService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(500, "Feign调用失败");
    }
}
