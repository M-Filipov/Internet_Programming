package org.elsys_bg.ex03.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class DateServer extends Thread {

	public static final int SERVER_PORT = 44012;

	private boolean running;

	private ServerSocket serverSocket;

	public DateServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		running = true;
	}

	public void run() {

		while (running) {
			try {
				final Socket clientSocket = serverSocket.accept();
				handleClient(clientSocket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void handleClient(final Socket clientSocket) throws IOException {
		final InputStream inputStream = clientSocket.getInputStream();
		final OutputStream outputStream = clientSocket.getOutputStream();

		final InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream);
		final BufferedReader in = new BufferedReader(inputStreamReader);
		final PrintWriter out = new PrintWriter(outputStream);
		final String readLine = in.readLine();

		
		try {
			System.out.println(parseDate(readLine));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		out.flush();

		clientSocket.close();
	}

	private long parseDate(String readLine) throws ParseException {
		DateFormatter dateFormatter = new DateFormatter();
		return dateFormatter.getDateDiff(dateFormatter.getCurrentDate(),
				dateFormatter.formatDateStr(readLine), TimeUnit.DAYS);

	}

}
