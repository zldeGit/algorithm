import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 张璐
 * @date 2022/9/6
 */
public class Test {
	public static void main(String[] args) throws IOException {
		ExecutorService executor = Executors.newFixedThreadPool(128);
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress(1234));
// 循环等待新连接
		while (true) {
			Socket socket = serverSocket.accept();
// 为新的连接创建线程执行任务
			executor.submit(new ConnectionTask(socket));
		}
	}

	public static class ConnectionTask extends Thread {
		private Socket socket;

		public ConnectionTask(Socket socket) {
			this.socket = socket;
		}

		public void run() {
				InputStream inputStream = null;
				OutputStream outputStream = null;
				try {
					inputStream = socket.getInputStream();
// read from socket...
					byte[] bytes = new byte[1024];
					int read = inputStream.read(bytes);
					System.out.println(bytes);
					outputStream = socket.getOutputStream();
// write to socket...
					outputStream.write("aaaa".getBytes());
					outputStream.close();
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
				}
		}
	}
}
