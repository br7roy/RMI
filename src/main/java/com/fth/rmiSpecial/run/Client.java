/*
* Package com.fth.rmi 
* FileName: Client
* Author:   fth
* Date:     2017/4/7 14:38
*/
package com.fth.rmiSpecial.run;

import com.fth.InvokeException;
import com.fth.rmiSpecial.deploy.KSoaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.rmi.Remote;
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
    static private Logger logger = LoggerFactory.getLogger(Client.class);

    {
        init();
    }

    private static Map<String, KSoaClient> serviceMethod = new HashMap<>();

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Client client = new Client();
        client.invoke("queryName", "");
    }


    private static void init() {
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1", 8082);
            String[] serverNames = registry.list();
            for (String serverName : serverNames) {
                logger.info("----------->搜索到的服务列表：[" + serverName + "]<-----------");

                Remote remote = registry.lookup(serverName);
                KSoaClient kSoaClient = (KSoaClient) registry.lookup(serverName);
                serviceMethod.put(kSoaClient.getName(), kSoaClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private Object invoke(String serverName, String... args) {
        Object invokeResult = null;
        KSoaClient kSoaClient = serviceMethod.get(serverName);

        if (kSoaClient == null) {
            throw new InvokeException("-------->不存在此服务[" + serverName + "]<--------");
        }

        invokeResult = kSoaClient.invoke(args);

        logger.info("----------->result of MY RMI SERVER:" + invokeResult + "<-----------");

        return invokeResult;
    }
}
