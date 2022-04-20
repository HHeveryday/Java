package genericity;

/**
  泛型方法的定义格式：
  修饰符<泛型变量> 返回值类型 方法名称 (形参列表){

 }
 注意：方法定义了是什么泛型变量，后面就只能用什么泛型变量。
 泛型的核心思想：是把出现泛型变量的地方全部替换成传输的真实数据类型。


 需求：给一个任何类型的数组，都能返回它的内容。
 */
public class GenericDemo {
    public static void main(String[] args) {
        Integer[] arr1 = {0, 1, 2};
        String[] arr2 = {"测试1", "测试2", "测试3"};
        showarr(arr1);
        showarr(arr2);


    }
    public static <E> void showarr(E[] arr){
        if (arr != null){
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                System.out.print(i == arr.length - 1 ? "": ", ");
            }
            System.out.print("]");
        }else {
            System.out.println(arr);
        }
    }
}
