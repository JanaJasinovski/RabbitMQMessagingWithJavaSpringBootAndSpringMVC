package come.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TopicPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		factory.setUsername("jana");
		factory.setPassword("jana");
		Channel channel = connection.createChannel();
		
		String message = "Message for Mobile and AC";
		
		channel.basicPublish("Topic-Exchange", "tv.mobile.ac", null, message.getBytes());
		
		channel.close();
		connection.close();
	}

}
