package register;

import framework.URL;

import java.io.*;
import java.util.*;

public class RemoteMapRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url){
        List<URL> list = Collections.singletonList(url);
        REGISTER.put(interfaceName, list);

        saveFile();
    }

    public static URL random(String interfaceName){
        REGISTER = getFile();

        List<URL> list = REGISTER.get(interfaceName);
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }

    private static void saveFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/cuiwei11/temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Map<String, List<URL>> getFile(){

        try {
            FileInputStream fileINputStream = new FileInputStream("/Users/cuiwei11/temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileINputStream);

            return (Map<String, List<URL>>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
    

}
