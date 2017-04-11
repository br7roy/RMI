/*
* Package com.fth.rmi 
* FileName: Client
* Author:   fth
* Date:     2017/4/7 14:38
*/
package com.fth.rmiSpecial.run;

import com.fth.rmiSpecial.deploy.KSoaClient;

import java.lang.reflect.InvocationTargetException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName:    Client
 * Author:      Br7roy
 * Date:        2017/4/7
 * Description: 远程对象调用 客户端
 */
public class Client {

    {
        init();
    }
    public static Map<String,KSoaClient> serviceMethod = new HashMap<>();

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Client client = new Client();
        client.invoke("queryName","");
    }


    private static void init(){
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1", 8082);
            String[] serverNames = registry.list();
            for (String serverName : serverNames) {
                System.out.println("----------->搜索到的服务列表：[" + serverName + "]<-----------");
                Remote remote = registry.lookup(serverName);
                KSoaClient kSoaClient = (KSoaClient)registry.lookup(serverName);
                serviceMethod.put(kSoaClient.getName(), kSoaClient);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public Object invoke(String serverName, String...args) {
        Object invokeResult = null;
        try{
            KSoaClient kSoaClient = serviceMethod.get(serverName);

            if (kSoaClient == null){
                System.out.println("不存在此服务");
                return null;
            }

            invokeResult = kSoaClient.invoke(args);

        System.out.println("----------->result of MY RMI SERVER:" + invokeResult + "<-----------");

    }catch (Exception e) {
		e.printStackTrace();
	}
        return invokeResult;
    }
}
