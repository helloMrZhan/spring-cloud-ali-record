package com.zjq.rocketmq.producer.controller;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test
 * @author zjq
 */
@RestController
public class ProviderController {

    Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @GetMapping(value = "/send_s1_gdp")
    public String send1() throws MQClientException {
        //创建DefaultMQProducer消息生产者对象
        DefaultMQProducer producer = new DefaultMQProducer("producer-group");
        //设置NameServer节点地址，多个节点间用分号分割
        producer.setNamesrvAddr("192.168.31.200:9876;192.168.31.201:9876");
        //与NameServer建立长连接
        producer.start();
        try {
            //发送一百条数据
            for(int i = 0 ; i< 100 ; i++) {
                //数据正文
                String data = "{\"title\":\"X市2021年度第一季度gdp汇总数据\"}";
                /*创建消息
                    Message消息三个参数
                    topic 代表消息主题，自定义为tax-data-topic说明是税务数据
                    tags 代表标志，用于消费者接收数据时进行数据筛选。2021S1代表2021年第一季度数据
                    body 代表消息内容
                */
                Message message = new Message("tax-data-topic", "2021S1", data.getBytes());
                //发送消息，获取发送结果
                SendResult result = producer.send(message);
                //将发送结果对象打印在控制台
                logger.info("消息已发送：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
            }
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
        return "success";
    }
}
