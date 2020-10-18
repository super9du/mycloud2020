package liu.wolf.mycloud.dao;

import liu.wolf.mycloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Demo PaymentDao
 *
 * @author Wolf-Liu
 * @date 2020/10/16 21:11
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
