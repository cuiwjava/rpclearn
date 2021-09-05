package register;

import framework.URL;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteMapRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url){
        List<URL> list = Collections.singletonList(url);
        REGISTER.put(interfaceName, list);
    }
}
