package liu.wolf.mycloud.controller;

import liu.wolf.mycloud.service.MessageSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Demo MessageSendController
 *
 * @author Wolf-Liu
 * @date 2020/11/5 23:26
 */
@RestController
public class MessageSendController {
    @Resource
    private MessageSender sender;

    @GetMapping("send")
    public String send() {
        return sender.send();
    }
}
