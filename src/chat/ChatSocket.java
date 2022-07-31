package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/10/31
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ChatSocket extends Thread {

    Socket socket;

    public ChatSocket(Socket socket) {
        this.socket = socket;
    }

    public void out(String s) {
        try {
            socket.getOutputStream().write((s + "\n").getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            String s;

            while ((s = bReader.readLine()) != null) {
                System.out.println(s);
                ChatManager.getChatManager().publish(this, s);
            }
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
