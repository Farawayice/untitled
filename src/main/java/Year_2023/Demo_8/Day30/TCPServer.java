package Year_2023.Demo_8.Day30;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建BS版本的TCP服务器
 * @author liulihua
 * @date 2023/8/30
 *
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket和系统指定的端口号
        ServerSocket server = new ServerSocket(8080);
        //使用accept方法获取到请求的客户端对象（服务器）
        Socket socket = server.accept();
        //使用Socket对象中的方法getInputStream 获取到网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
//        //使用网络字节输入流InputStream对象中的方法read读取客户端的请求信息
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = is.read(bytes))!=-1){
//            System.out.println(new String(bytes,0,len));
//        }
        //把is网络字节输入流对象，转换为字符换从输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //把客户端请求信息的第一行读取出来，GET src/main/java/Year_2023/Demo_8/Day30/index.html HTTP/1.1
        String line = br.readLine();
        //把读取到的信息进行切割，只要中间部分 src/main/java/Year_2023/Demo_8/Day30/index.html
        String[] arr = line.split(" ");
        ;
        //把路径前边的/去掉,进行截取
        String htmlpath = arr[1].substring(1);
        //创建一个本地字节输入流，构造方法中绑定要读取的html路径
        FileInputStream fis = new FileInputStream(htmlpath);
        //使用socket中的方法getOutputStream获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();

        //写入HTTP协议响应头，固定写法
        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content.Type:text/html\r\n".getBytes());
        //必须写入空行，否则浏览器不解析
        os.write("\r\n".getBytes());
        //一读一写复制文件，把服务器读取的html文件回写到客户端
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        //把缓冲区写完
        os.flush();
        //释放资源
        os.close();
        fis.close();
        socket.close();
        server.close();
    }
}
