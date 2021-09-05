package provider;

import framework.Protocol;
import framework.ProtocolFactory;
import framework.URL;
import protocol.http.HttpProtocol;
import protocol.http.HttpServer;
import provider.api.HelloService;
import provider.impl.HelloServiceImpl;
import register.RemoteMapRegister;

public class Provider {
    public static void main(String[] args) {


        // 1.本地注册
        // 服务名：实现类
         LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

         // 2.远程注册
         // 服务名
        URL url = new URL("localhost", 8080);
        RemoteMapRegister.register(HelloService.class.getName(), url);

        // 3.启动tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);

        Protocol protocol = ProtocolFactory.getProtocol(url);
        protocol.start(url);


    }
}
