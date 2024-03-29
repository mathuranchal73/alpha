package com.alpha.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.alpha.model.Student;

@Service
public class Producer {
	
	 private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	 @Value("${tpd.topic-name}")
	 private static String TOPIC="amazingTopic";
	 
	 @SuppressWarnings("rawtypes")
	 @Autowired
	 KafkaTemplate kafkaTemplate;
	 
	  @SuppressWarnings("unchecked")
	  public void sendMessage(Student student) {
          ProducerRecord<String, Student> rec = new ProducerRecord<String, Student>(TOPIC,student);
	        logger.info(String.format("#### -> Producing message -> %s", student));
	        this.kafkaTemplate.send(rec);
	     
	    }
	    

}
