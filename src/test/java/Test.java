import jdk.nashorn.internal.parser.JSONParser;
import sun.security.util.ArrayUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 张璐
 * @date 2022/9/6
 */
public class Test {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		// 注意 hasNext 和 hasNextLine 的区别
		in.nextLine();
		String line = in.nextLine();
		String[] arr =line.split(" ");
		Arrays.sort(arr);
		int imax = arr.length -1;
		StringBuilder ans = new StringBuilder();
		for(int i=0; ;i++){
			if(i==imax){
				System.out.println(ans.append(arr[i]));
				break;
			}
			ans.append(arr[i]).append(" ");
		}
	}

}
