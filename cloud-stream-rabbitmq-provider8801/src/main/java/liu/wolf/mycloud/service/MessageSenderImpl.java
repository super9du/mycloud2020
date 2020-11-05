package liu.wolf.mycloud.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Demo MessageSenderImpl
 *
 * @author Wolf-Liu
 * @date 2020/11/5 23:18
 */
@EnableBinding(Source.class)
public class MessageSenderImpl implements MessageSender {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String payload = UUID.randomUUID().toString();
        System.out.println("payload>>>>>" + payload);
        Message<String> msg = MessageBuilder.withPayload(payload).build();
        output.send(msg);
        return payload;
    }
}
