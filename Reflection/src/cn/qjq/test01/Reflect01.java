package cn.qjq.test01;

/**
 *了解生成Class对象的三种方式
 *测试各种类型生产Class对象的方法
 * Created by qjq on 2019/12/22 18:59
 */
@SuppressWarnings("all")
public class Reflect01 {
    public static void main(String[] args) {
        String path = "cn.qjq.bean.User";
        try {
            //第一种方式
            Class clazz = Class.forName(path);
            //对象是表示或封装一些数据类型。一个类被加载后，JVM会自动创建一个该类的Class对象，
            //类的整个结构信息会被放到Class对象中去。
            //这个Class就像一面镜子，通过这面镜子，我们就能看到对应类的全部信息。
            System.out.println(clazz.hashCode());
            //一个类只对应一个Class
            Class clazz2 = Class.forName(path);
            System.out.println(clazz2.hashCode()==clazz.hashCode());
            //第二种方式
            Class strClazz = path.getClass();
            //第三种方式
            Class str2Clazz = String.class;//字符型创建的Class都是相同的
            Class intClazz = int.class;
            System.out.println(strClazz.hashCode()==str2Clazz.hashCode());

            int[] arr01 = new int[10];
            int[] arr02 = new int[20];
            int[][] arr03 = new int[10][20];
            System.out.println(arr01.getClass().hashCode()==arr02.getClass().hashCode());//虽然长度不同，但Class还是一样
            System.out.println(arr01.getClass().hashCode()==arr03.getClass().hashCode());//只有维数不同时，Class才不会相同

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
