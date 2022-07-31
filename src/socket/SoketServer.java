package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/10/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class SoketServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        Socket clientSocket = null;
        BufferedReader in = null;
        int port = 5000;

        String str = null;
        try {
            //第一步
            serverSocket = new ServerSocket(port);    //创建服务器套接字

            System.out.println("服务器开启，等待连接。。。");

            //第二步
            clientSocket = serverSocket.accept();// 获得链接

            //接收客户端发送的内容
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {
                str = in.readLine();//从套接字中读取一行作为数据
                System.out.println("收到客户端发送的内容为：" + str);
                Thread.sleep(2000);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
