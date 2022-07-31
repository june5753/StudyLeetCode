package chat;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/10/31
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ServerListener extends Thread {

    @Override
    public void run() {
        //端口范围:1-65535
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(1989);
            while (true) {
                Socket socket = serverSocket.accept();
                JOptionPane.showMessageDialog(null, "有客户端连接到了1989端口");
                System.out.println("有客户端连接到了1989端口");
                ChatSocket cs = new ChatSocket(socket);
                cs.start();
                ChatManager.getChatManager().add(cs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
