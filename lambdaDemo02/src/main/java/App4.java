/**
 * Created by IntelliJ IDEA.
 * User: zmq
 * Date: 2020/4/19
 */
public class App4 {
    String s1 = "全局变量";

    public void testInnerClass(){
        String s2 = "局部变量";
        new Thread(new Runnable() {
            String s3 = "内部变量";
            @Override
            public void run() {
                // 访问全局变量
//                System.out.println(this.s1);// this关键字~表示是当前内部类型的对象
                System.out.println(s1);

                System.out.println(s2);// 局部变量的访问，~不能对局部变量进行数据的修改[final]
//                s2 = "hello";

                System.out.println(s3);
                System.out.println(this.s3);
            }
        }).start();
    }

    public void testLambda(){
        String s2 = "局部变量";
        new Thread(()->{
            String s3 = "内部变量lambda";
            // 访问全局变量
            System.out.println(this.s1);// this关键字，表示的就是所属方法所在类型的对象
            // 访问局部变量
            System.out.println(s2);
//            s2 = "hello";// 不能进行数据修改，默认推导变量的修饰符：final
            System.out.println(s3);
            s3 = "labmda 内部变量直接修改";
            System.out.println(s3);
        }).start();
    }
    public static void main(String[] args) {
        App4 app4 = new App4();
        app4.testInnerClass();
        app4.testLambda();
    }
}
