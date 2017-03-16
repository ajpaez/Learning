package net.socket;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainSocket {

	public static void main(String[] args) {

		try {

			Thread server = new Thread() {
				GreetServer server = new GreetServer();

				@Override
				public void run() {
					super.run();
					try {

						server.start(6666);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				@Override
				protected void finalize() throws Throwable {
					super.finalize();
					server.stop();
				}

			};

			ExecutorService executor = Executors.newFixedThreadPool(5);
			executor.execute(server);

			GreetClient client = new GreetClient();
			client.startConnection("127.0.0.1", 6666);
			String resp1 = client.sendMessage("hello");
			System.out.println("Response from socket: " + resp1);
			String resp2 = client.sendMessage("world");
			System.out.println("Response from socket: " + resp2);
			String resp3 = client.sendMessage("!");
			System.out.println("Response from socket: " + resp3);
			String resp4 = client.sendMessage(".");
			System.out.println("Response from socket: " + resp4);

			client.stopConnection();

			GreetClient.isSocketAlive("127.0.0.1", 6661);

			executor.shutdown();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
