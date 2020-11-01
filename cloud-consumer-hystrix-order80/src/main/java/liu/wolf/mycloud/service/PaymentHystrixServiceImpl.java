package liu.wolf.mycloud.service;

import org.springframework.stereotype.Component;

/**
 * Demo PaymentHystrixServiceImpl
 *
 * @author Wolf-Liu
 * @date 2020/11/1 22:51
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String ok(Long id) {
        return "hystrix（ok+" + id + "）: 请求失败，请稍后再试！";
    }

    @Override
    public String timeout(Long id) {
        return "hystrix（timeout+" + id + "）: 请求失败，请稍后再试！";
    }

    @Override
    public String exception(Long id) {
        return "hystrix（exception+" + id + "）: 请求失败，请稍后再试！";
    }
}
