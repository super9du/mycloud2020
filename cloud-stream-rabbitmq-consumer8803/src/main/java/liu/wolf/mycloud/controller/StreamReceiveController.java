package liu.wolf.mycloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Demo StreamReceiveController
 *
 * @author Wolf-Liu
 * @date 2020/11/5 23:43
 */
@Component
@EnableBinding(Sink.class)
public class StreamReceiveController {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<?> message) {
        System.out.println("接收到消息 >>> port=" + port + "; " + "message=" + message.getPayload());
    }
}
