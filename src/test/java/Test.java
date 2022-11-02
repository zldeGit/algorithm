import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 张璐
 * @date 2022/9/6
 */
public class Test {
	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress( "192.168.18.20",10016));
		ByteBuffer buf = ByteBuffer.allocate(1024);

		int bytesRead = socketChannel.read(buf);
		while (bytesRead != -1) {
			socketChannel.read(buf);
			System.out.println(buf);
		}
	}

}
