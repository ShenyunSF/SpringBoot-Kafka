package com.shenyun.handler;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;
@Component
public class KafkaSendResultHandler implements ProducerListener {
	private static final Logger log = LoggerFactory.getLogger(KafkaSendResultHandler.class);

	@Override
	public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
		log.info("Message send error : "+"topic:"+topic+"partition:"+partition+"key:"+key+"value:"+value);
		
	}

	@Override
	public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
		log.info("Message send success : "+"topic:"+topic+"partition:"+partition+"key:"+key+"value:"+value);
		
	}

	@Override
	public boolean isInterestedInSuccess() {
		return false;
	}
	


	

}
