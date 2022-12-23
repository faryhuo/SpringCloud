package com.bilibili.moment.config;

import com.bilibili.moment.constant.MomentConstant;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;


@Configuration
public class RocketMQConfig {
    @Value("${rocketmq.server.address}")
    private String serverAddress;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Bean("momentsProducer")
    public DefaultMQProducer momentsProducer() throws MQClientException {
        DefaultMQProducer defaultMQProducer=new DefaultMQProducer(MomentConstant.PRODUCT_GROUP);
        defaultMQProducer.setNamesrvAddr(serverAddress);
        defaultMQProducer.start();
        return defaultMQProducer;
    }

    @Bean("momentConsumer")
    public DefaultMQPushConsumer momentConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer=new DefaultMQPushConsumer(MomentConstant.PRODUCT_GROUP);
        consumer.setNamesrvAddr(serverAddress);
        consumer.subscribe(MomentConstant.TOPIC_MOMENTS,"*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for(MessageExt messageExt: list){
                    System.out.println(messageExt);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        return consumer;
    }
}
