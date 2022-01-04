package com.zjq.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * @author zjq
 * @date 2022/1/3 21:41
 * <p>title:RocketMQ消费者服务</p>
 * <p>description:</p>
 */
@SpringBootApplication
public class RocketmqConsumerApplication {

    private static Logger logger = LoggerFactory.getLogger(RocketmqConsumerApplication.class);
    public static void main(String[] args) throws MQClientException {
        SpringApplication.run(RocketmqConsumerApplication.class, args);
        //创建消费者对象
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer-group");
        //设置NameServer节点
        consumer.setNamesrvAddr("192.168.31.200:9876;192.168.31.201:9876");
        /*订阅主题，
        consumer.subscribe包含两个参数：
        topic: 说明消费者从Broker订阅哪一个主题，这一项要与Provider保持一致。
        subExpression: 子表达式用于筛选tags。
            同一个主题下可以包含很多不同的tags，subExpression用于筛选符合条件的tags进行接收。
            例如：设置为*，则代表接收所有tags数据。
            例如：设置为2020S1，则Broker中只有tags=2020S1的消息会被接收，而2020S2就会被排除在外。
        */
        consumer.subscribe("gdp-data-topic", "*");
        //创建监听，当有新的消息监听程序会及时捕捉并加以处理。
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(
                    List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                //批量数据处理
                for (MessageExt msg : msgs) {
                    logger.info("消费者消费数据:"+new String(msg.getBody()));
                }
                //返回数据已接收标识
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者，与Broker建立长连接，开始监听。
        consumer.start();
    }
}
