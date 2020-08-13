package practise;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/08/10
 *     desc   : 自定义实现LRU算法
 *     面试中和图片加载库原理中经常遇到
 *     version: 1.0
 * </pre>
 */
public class MyLRU extends LinkedHashMap<Integer, Integer> {
        String name = "yjune";

    private int capacity;

    public MyLRU(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {

    }
}
