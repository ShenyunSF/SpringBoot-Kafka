package com.shenyun.springCloud.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {
	@Autowired
	private KafkaTemplate kafkaTemplate;

	@Test
	public void testDemo() throws InterruptedException {
		kafkaTemplate.send("topic.quick.demo", "this is my first demo");
		// 休眠5秒，为了使监听器有足够的时间监听到topic的数据 
		Thread.sleep(5000);
	}
	
	
	
	@Autowired
	private KafkaTemplate defaultKafakaTemplate;
	
	@Test
	public void testDefaultKafkaTemplate() throws InterruptedException {
		defaultKafakaTemplate.sendDefault("I`m send msg to default topic");
		Thread.sleep(5000);
	}

	@Test public void testTemplateSend() { 
		//发送带有时间戳的消息 
		kafkaTemplate.send("topic.quick.demo", 0, System.currentTimeMillis(), 0); 
		//使用ProducerRecord发送消息 
		ProducerRecord record = new ProducerRecord("topic.quick.demo", "use ProducerRecord to send message"); 
		kafkaTemplate.send(record); 
		//使用Message发送消息 
		Map map = new HashMap(); 
		map.put(KafkaHeaders.TOPIC, "topic.quick.demo"); 
		map.put(KafkaHeaders.PARTITION_ID, 0); 
		map.put(KafkaHeaders.MESSAGE_KEY, 0); 
		GenericMessage message = new GenericMessage("use Message to send message",new MessageHeaders(map)); 
		kafkaTemplate.send(message); 
		}


		
	
}
