package liu.wolf.mycloud.service;

import liu.wolf.mycloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Demo PaymentService
 *
 * @author Wolf-Liu
 * @date 2020/10/16 21:31
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
