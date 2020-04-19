import java.util.UUID;
import java.util.function.*;

/**
 * Created by IntelliJ IDEA.
 * User: zmq
 * Date: 2020/4/19
 */
public class App2 {
    public static void main(String[] args) {
        Predicate<String> pre = (String username)->{
            return "admin".equals(username);
        };
        System.out.println(pre.test("admin"));
        Consumer<String> consumer = (String message)->{
            System.out.println("消息发送："+message);
        };
        consumer.accept("这是一条消息");
        Function<String,Integer> fun = (String gender)->{
            return "male".equals(gender)?1:0;
        };
        System.out.println(fun.apply("male"));
        Supplier<String> sup = ()->{
          return UUID.randomUUID().toString();
        };
        System.out.println(sup.get());
        UnaryOperator<String> uo = (String image)->{
          image+="[100*100]";
          return image;
        };
        System.out.println(uo.apply("图片"));
        BinaryOperator<Integer> bo = (Integer i1,Integer i2)->{
            return i1>i2?i1:i2;
        };
        System.out.println(bo.apply(1,2));
        /*
       java.util.function提供了大量的函数式接口
        Predicate 接收参数T对象，返回一个boolean类型结果
        Consumer 接收参数T对象，没有返回值
        Function 接收参数T对象，返回R对象
        Supplier 不接受任何参数，直接通过get()获取指定类型的对象
        UnaryOperator 接口参数T对象，执行业务处理后，返回更新后的T对象
        BinaryOperator 接口接收两个T对象，执行业务处理后，返回一个T对象
         */
    }
}
