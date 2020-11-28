package liu.wolf.mycloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo FlowLimitController
 *
 * @author Wolf-Liu
 * @date 2020/11/22 14:35
 */
@RestController
@RequestMapping("flow")
public class FlowLimitController {

    @GetMapping("a")
    public String getA() {
        return "--------------- test A ------------------";
    }

    @GetMapping("b")
    public String getB(){
        return "--------------- test B ------------------";
    }
}
