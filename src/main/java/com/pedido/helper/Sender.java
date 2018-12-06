package com.pedido.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.pedido.model.Pedido;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Sender {

	private static final String QUEUE_NAME = "mensagem-de-entregas";

	public static void enviarMensagem(Pedido pedido) {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			// criar a conexão com o  "Rabbit Server" e pegando o channel.
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			// Declarando a fila
			channel.queueDeclare(QUEUE_NAME, true, false, false, null);

			String message = "";
			if(pedido!=null) {
				message = pedido.getIdPedido() + " - " + pedido.getEnderecoEntrega();
			}
			if (!message.trim().isEmpty()) {
				channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			}

			// fechando a conexão.
			channel.close();
			connection.close();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(String.format("Um erro ocorreu [%s]. [%s]", e.getMessage(), e));
		}
	}
}