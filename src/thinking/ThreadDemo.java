package thinking;

import java.util.HashMap;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2021/02/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ThreadDemo {

    public static void main(String[] args) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.putIfAbsent("A","888");
        hashMap.putIfAbsent("A","99"); //key 重复，则不覆盖
        hashMap.put("B","6");

        System.out.println(hashMap.get("A"));
    }
}
