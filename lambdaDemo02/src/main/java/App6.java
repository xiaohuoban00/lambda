/**
 * Created by IntelliJ IDEA.
 * User: zmq
 * Date: 2020/4/19
 */
public class App6 {
    public static void main(String[] args) {
        App6 app6 = new App6();
        app6.lambdaMethod((Param1) (info)->{

        });
    }
    interface Param1 {
        void outInfo(String info);
    }

    interface Param2 {
        void outInfo(String info);
    }

    // 定义重载的方法
    public void lambdaMethod(Param1 param) {
        param.outInfo("hello param1 imooc!");
    }
    public void lambdaMethod(Param2 param) {
        param.outInfo("hello param2 imooc");
    }


}
