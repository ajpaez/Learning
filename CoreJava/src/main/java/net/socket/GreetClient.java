package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class GreetClient {

	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public void startConnection(String ip, int port) throws UnknownHostException, IOException {

		InetAddress inteAddress = InetAddress.getByName(ip);
		SocketAddress socketAddress = new InetSocketAddress(inteAddress, port);

		// create a socket
		clientSocket = new Socket();

		// this method will block no more than timeout ms.
		int timeoutInMs = 10 * 1000; // 10 seconds
		clientSocket.connect(socketAddress, timeoutInMs);

		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}

	public String sendMessage(String msg) throws IOException {
		out.println(msg);
		String resp = in.readLine();
		return resp;
	}

	public void stopConnection() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
	}

	public static boolean isSocketAlive(String ip, int port) {
		boolean isAlive = false;

		// Creates a socket address from a hostname and a port number
		SocketAddress socketAddress = new InetSocketAddress(ip, port);
		Socket socket = new Socket();

		// Timeout required - it's in milliseconds
		int timeout = 2000;

		System.out.println("Ip: " + ip + ", port: " + port);
		try {
			socket.connect(socketAddress, timeout);
			socket.close();
			isAlive = true;

		} catch (SocketTimeoutException exception) {
			System.out.println("SocketTimeoutException " + ip + ":" + port + ". " + exception.getMessage());
		} catch (IOException exception) {
			System.out.println("IOException - Unable to connect to " + ip + ":" + port + ". " + exception.getMessage());
		}
		return isAlive;
	}

}
