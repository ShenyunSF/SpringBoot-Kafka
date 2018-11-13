package com.shenyun.springCloud.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.shenyun.handler.KafkaSendResultHandler;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KafkaSendResultHandlerDemo {
	@Autowired
	private KafkaSendResultHandler producerListener;
	@Autowired
	private KafkaTemplate kafkaTemplate;
	
	@Test
	public void testProducerListen() throws InterruptedException {
		kafkaTemplate.setProducerListener(producerListener);
		kafkaTemplate.send("topic.quick.demo", "test producer listen");
		Thread.sleep(1000);
	}
}
