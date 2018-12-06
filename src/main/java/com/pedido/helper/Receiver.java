package com.pedido.helper;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Receiver {

	private static final String QUEUE_NAME = "mensagem-de-entregas";
	private static String  fila;
	
	public static String[] pegarMensagemDaFila() throws IOException, TimeoutException, InterruptedException {
		fila = "";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		Consumer consumer = new DefaultConsumer(channel) {
		    @Override
		     public void handleDelivery(
		        String consumerTag,
		        Envelope envelope, 
		        AMQP.BasicProperties properties, 
		        byte[] body) throws IOException {
		  
		            String message = new String(body, "UTF-8");
		            fila += message + "/";
		     }
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
		Thread.sleep(3000);
		if(!fila.equals("")) {
			String[] split = fila.split("/");
			return split;
		}else {
			System.out.println("Não possui elementos na fila!");
			return null;
		}
			
	}
}