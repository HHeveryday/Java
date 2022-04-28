package stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * 各种流的获取
 */

public class Demo1 {
    public static void main(String[] args) {
        //Collection集合的获取流
        Collection<String> list = new ArrayList<>();
        Stream<String> stringStream = list.stream();

        /*Map集合获取流*/
        Map<String,Integer> map = new HashMap<>();
        //获取键流
        Stream<String> keyStream = map.keySet().stream();
        //获取值流
        Stream<Integer> valueStream = map.values().stream();

        //获取键值对流
        Stream<Map.Entry<String, Integer>> keyandvalueStream = map.entrySet().stream();


        /**
         * 数组获取流
         */

        String[] strings = {"小明", "小芳"};
        //方法1
        Stream<String> arrStream = Arrays.stream(strings);
        //方法2
        Stream<String> arrStream2 = Stream.of(strings);

    }
}
