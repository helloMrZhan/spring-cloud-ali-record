package com.zjq.rocketmq.quickstart;

import java.util.List;

import com.zjq.rocketmq.constants.NameServerAddrConst;
import org.apache.rocketmq.client.consumer.AllocateMessageQueueStrategy;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * rocketMQ 消费者
 * @author zjq
 */
public class Consumer {


	public static void main(String[] args) throws MQClientException {
		// 创建消费者对象
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_quick_consumer_name");
		// 设置NameServer节点
		consumer.setNamesrvAddr(NameServerAddrConst.NAMESRV_ADDR_SINGLE);
		// 设置消费位置，从哪个点开始
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
		/*订阅主题，
        consumer.subscribe包含两个参数：
        topic: 说明消费者从Broker订阅哪一个主题，这一项要与Provider保持一致。
        subExpression: 子表达式用于筛选tags。
            同一个主题下可以包含很多不同的tags，subExpression用于筛选符合条件的tags进行接收。
            例如：设置为*，则代表接收所有tags数据。
            例如：设置为2022S1，则Broker中只有tags=2022S1的消息会被接收，而2022S2就会被排除在外。
        */
		consumer.subscribe("test_quick_topic", "*");
		// 创建监听，当有新的消息监听程序会及时捕捉并加以处理。
		consumer.registerMessageListener(new MessageListenerConcurrently() {

			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				MessageExt me = msgs.get(0);
				try {
					String topic = me.getTopic();
					String tags = me.getTags();
					String keys = me.getKeys();
//					if(keys.equals("key1")) {
//						System.err.println("消息消费失败..");
//						int a = 1/0;
//					}

					String msgBody = new String(me.getBody(), RemotingHelper.DEFAULT_CHARSET);
					System.err.println("topic: " + topic + ",tags: " + tags + ", keys: " + keys + ",body: " + msgBody);
				} catch (Exception e) {
					e.printStackTrace();
//					int recousumeTimes = me.getReconsumeTimes();
//					System.err.println("recousumeTimes: " + recousumeTimes);
//					if(recousumeTimes == 3) {
//						//		记录日志....
//						//  	做补偿处理
//						return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//					}

					return ConsumeConcurrentlyStatus.RECONSUME_LATER;
				}
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		// 启动消费者，与Broker建立长连接，开始监听。
		consumer.start();
		System.err.println("consumer start...");

	}
}
