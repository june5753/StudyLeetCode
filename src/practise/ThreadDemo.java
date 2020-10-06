package practise;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/08/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ThreadDemo {

    public static void main(String[] args) {
        CustomerThread thread = new CustomerThread();
        thread.start();
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
    }

    private static class CustomerThread extends Thread {
        @Override
        public void run() {
            System.out.println("CustomerThread is run");
        }
    }
}
