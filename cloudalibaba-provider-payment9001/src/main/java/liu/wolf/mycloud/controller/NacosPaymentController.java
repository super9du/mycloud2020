package liu.wolf.mycloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo NacosPaymentProvider
 *
 * @author Wolf-Liu
 * @date 2020/11/15 18:58
 */
@RestController
@RequestMapping("payment")
@RefreshScope
public class NacosPaymentController {
    @Value("${spring.application.name}")
    private String serverName;

    @Value("${server.port}")
    private String port;

    @Value(("${config.info}"))
    private String configInfo;

    @GetMapping("{id}")
    public String get(@PathVariable("id") Long id) {
        return "Server Name: " + serverName + "<br>From Port: " + port + "<br>ID: " + id;
    }

    @GetMapping("config")
    public String getConfig() {
        return "Server Name: " + serverName + "<br>From Port: " + port + "<br>configInfo: " + configInfo;
    }
}
