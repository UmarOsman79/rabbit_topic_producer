package gmail.umarosman77.producer.service;

import gmail.umarosman77.producer.model.Person;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {

	@Autowired
	AmqpTemplate rabbitTemplateBean;

	@Value("${rabbitmq.exchange:test.exchange}")
	String exchange;

	public void send(Person person) {
		rabbitTemplateBean.convertAndSend(exchange, Person.class.getName(), person);
	}
}
