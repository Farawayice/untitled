package Year_2023.Demo_6.Day28;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liulihua
 * @date 2023/6/28 15:35
 * TCP通信的服务器端：接受服务器端的请求，读取客户端发送的数据，给客户端回写数据
 * 表示服务器的类：
 *      java.net.ServerSocket:此类实现服务器套接字。
 * 构造方法：
 *      ServerSocket(int port)创建绑定到特定端口的服务器套接字
 *      服务器端明确:必须知道是那个客户端请求的服务器
 *      所以可以使用accept方法获取到请求的Socket类
 *      成员方法：
 *           Socket accept()侦听并接受到此套接字的连接。
 *      服务器实现步骤：
 *          1.创建服务器ServerSocket对象和系统指定的端口号
 *          2.使用ServerSocket中的方法accept,获取到请求的客户端对象Socket
 *          3.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
 *          4.使用网络字节输入流InputStream对象中的方法read,读取客户端发送的数据
 *          5.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象
 *          6.使用网络字节输出流OutputStream对象中的方法write,给服务器端回写数据
 *          7.释放资源（Socket,ServerSocket）
 *
 */
public class TCPServers {
    public static void main(String[] args) throws IOException {
        // 1.创建服务器ServerSocket对象和系统指定的端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        // 2.使用ServerSocket中的方法accept,获取到请求的客户端对象Socket
        Socket socket = serverSocket.accept();
        // 3.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        // 4.使用网络字节输入流InputStream对象中的方法read,读取客户端发送的数据
        byte []bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        // 5.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        // 6.使用网络字节输出流OutputStream对象中的方法write,给服务器端回写数据
        os.write("服务器收到！".getBytes());
        //  7.释放资源（Socket,ServerSocket）
        socket.close();
        serverSocket.close();
    }
}
