package chat;

import java.util.Vector;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/10/31
 *     desc   :
 *     /**
 *  * [Android通信]基于socket的聊天app(一)：实现一对多通信
 *  https://blog.csdn.net/lyh916/article/details/48879185
 *  OK 成功实现流程
 *  * @author yangjun
 *     version: 1.0
 * </pre>
 */
public class ChatManager {
    Vector<ChatSocket> vector = new Vector<ChatSocket>();

    private ChatManager() {
    }

    private static final ChatManager cm = new ChatManager();

    public static ChatManager getChatManager() {
        return cm;
    }

    public void add(ChatSocket chatSocket) {
        vector.add(chatSocket);
    }

    public void publish(ChatSocket chatSocket, String s) {
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket cs = vector.get(i);
            if (!cs.equals(chatSocket)) {
                cs.out(s);
            }
        }
    }
}
