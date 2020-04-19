/**
 * Created by IntelliJ IDEA.
 * User: zmq
 * Date: 2020/4/19
 */
public class App3 {
    public static void main(String[] args) {
        //1.lambda的基本语法
        /*
        1)声明：就是和lambda表达式绑定的接口类型
        2)参数：包含在一对圆括号中，和绑定的接口中的抽象方法中的参数个数及顺序一致。
        3)操作符：->
        4)执行代码块：包含在一对大括号中，出现在操作符号的右侧

        [接口声明] = (参数) -> {执行代码块};
         */
        Lambda1 lambda1 = ()->{
            System.out.println("lambda1");
        };
        Lambda1 lambda12 = ()-> System.out.println("hello lambda");
        lambda1.test();
        lambda12.test();
        Lambda2 lambda2 = (String name, int age)-> System.out.println(name+age);
        Lambda2 lambda21 = (name,age)-> System.out.println(name+age);
        lambda2.test("zmq",18);
        lambda21.test("zmq",22);
        Lambda3 lambda3 = (a, b) -> Math.max(a, b);
        Lambda3 lambda31 = (x,y)->x+y;
        System.out.println(lambda3.test(1,1));
        System.out.println(lambda31.test(1,2));
         /*
        1. lambda表达式，必须和接口进行绑定。
        2. lambda表达式的参数，可以附带0个到n个参数，括号中的参数类型可以不用指定，jvm在运行时，会自动根据绑定的抽象方法中电参数进行推导。
        3. lambda表达式的返回值，如果代码块只有一行，并且没有大括号，不用写return关键字，单行代码的执行结果，会自动返回。
            如果添加了大括号，或者有多行代码，必须通过return关键字返回执行结果。
         */
    }

    //没有参数，没有返回值的lambda表达式绑定的接口
    @FunctionalInterface
    interface Lambda1{
        void test();
    }
    // 带有参数，没有返回值的lambda表达式
    interface Lambda2{
        void test(String name, int age);
    }

    // 带有参数，带有返回值的lambda表达式
    interface Lambda3 {
        int test(int x, int y);
    }
}
