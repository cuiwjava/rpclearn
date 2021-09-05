package consumer;

import framework.Invocation;
import protocol.http.HttpClient;
import provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {


        HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{"cuiwjava"});
        String result = httpClient.send("localhost", 8080, invocation);

        System.out.println(result);
    }

}
