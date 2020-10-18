package liu.wolf.mycloud.service.impl;

import liu.wolf.mycloud.dao.PaymentDao;
import liu.wolf.mycloud.entity.Payment;
import liu.wolf.mycloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Demo PaymentServiceImpl
 *
 * @author Wolf-Liu
 * @date 2020/10/16 21:31
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
