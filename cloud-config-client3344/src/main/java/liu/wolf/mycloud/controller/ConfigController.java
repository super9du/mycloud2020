package liu.wolf.mycloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo ConfigController
 *
 * @author Wolf-Liu
 * @date 2020/11/4 23:04
 */
@RestController
@RefreshScope
@RequestMapping("config")
public class ConfigController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String port;

    @Value("${config.info}")
    private String config;

    @GetMapping
    public String get() {
        return appName + "(" + port + "): " + config;
    }
}
