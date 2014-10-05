package org.elsys_bg.ex03.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.elsys_bg.ex03.server.DateServer;

public class DateClient {

	private static final String SERVER = "localhost";

	private final String request;

	public DateClient(String request) {
		this.request = request;
	}

	private static String getInput() throws IOException {
		final InputStream input = System.in;
		final InputStreamReader inputStreamReader = new InputStreamReader(input);
		final BufferedReader reader = new BufferedReader(inputStreamReader);

		return reader.readLine();
	}

	private String send() throws IOException {
		final Socket clientSocket = new Socket(SERVER, DateServer.SERVER_PORT);

		final InputStream inputStream = clientSocket.getInputStream();
		final OutputStream outputStream = clientSocket.getOutputStream();

		final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		final BufferedReader in = new BufferedReader(inputStreamReader);

		final PrintWriter out = new PrintWriter(outputStream);

		out.println(request);

		out.flush();

		final String result = in.readLine();

		clientSocket.close();

		return result;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter date in YYYY-MM-DD format: ");

		final String request = getInput();

		final DateClient dateClient = new DateClient(request);

		final String response = dateClient.send();

		System.out.println("Days between the two dates: " + response);
	}
}
