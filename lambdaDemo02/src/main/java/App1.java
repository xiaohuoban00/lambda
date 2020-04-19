import com.zmq.MessageFormat;
import com.zmq.UserCredential;
import com.zmq.impl.MessageFormatImpl;
import com.zmq.impl.UserCredentialImpl;

/**
 * Created by IntelliJ IDEA.
 * 需求改动：
 * 所有的用户验证。可以同时获取用户的验证信息[是否成功|成功~返回用户|null]
 * User: zmq
 * Date: 2020/4/19
 */
public class App1 {
    public static void main(String[] args) {
        UserCredential userCredential = new UserCredentialImpl();
        System.out.println(userCredential.verifyUser("admin"));
        //默认方法
        System.out.println(userCredential.getCredential("admin"));
        //静态方法
        String msg = "hello word";
        if(MessageFormat.verifyMessage(msg)){
            MessageFormat messageFormat = new MessageFormatImpl();
            messageFormat.format(msg,"json");
        }
        //匿名内部类，实现接口的抽象方法
        UserCredential uc2 = new UserCredential() {
            @Override
            public String verifyUser(String username) {
                return "admin".equals(username)?"管理员":"会员";
            }
        };
        System.out.println(uc2.verifyUser("admin"));
        System.out.println(uc2.verifyUser("manager"));
        //lambda表达式，针对函数式接口的简单实现
        UserCredential uc3 = (String username)->{
            return "admin".equals(username)?"lambda管理员":"lambda会员";
        };
        System.out.println(uc3.verifyUser("admin"));
        System.out.println(uc3.verifyUser("manager"));
    }
}
