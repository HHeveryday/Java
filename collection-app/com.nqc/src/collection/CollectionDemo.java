package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 在遍历集合的过程中删除元素
 */
public class CollectionDemo {
    public static void main(String[] args) {
        List<String > list = new ArrayList<>();
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
        list.add("测试3");
        list.add("测试4");
        list.add("测试3");

        //使用迭代器进行删除操作

//        Iterator it = list.iterator();
//        while (it.hasNext()){
//            if (it.next().equals("测试3")){
//                it.remove("测试3");
//            }
//        }
//        System.out.println(list);

        //不能使用foreach和lambda进行边遍历边删除操作，不然会报错

        //使用for循环进行删除操作，注意使用--i或者从后往前删
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("测试3")){
                list.remove("测试3");
                --i;
            }
        }
        System.out.println(list);

    }
}
