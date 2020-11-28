package liu.wolf.mycloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import liu.wolf.mycloud.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo SentinelResourceController
 *
 * @author Wolf-Liu
 * @date 2020/11/26 22:02
 */
@RestController
public class SentinelResourceController {

    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandler = "exceptionHandler")
    public CommonResult<String> get() {
        return new CommonResult<>(200, "通过 Sentinel 获取", "通过 Sentinel 获取");
    }

    public CommonResult<String> exceptionHandler(BlockException e) {
        return new CommonResult<>(500, e.getMessage() + "<br>" + e.getClass().getName());
    }
}
